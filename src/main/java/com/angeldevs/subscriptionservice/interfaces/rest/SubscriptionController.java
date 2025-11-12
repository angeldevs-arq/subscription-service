package com.angeldevs.subscriptionservice.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angeldevs.subscriptionservice.domain.model.queries.GetPaymentMethodsByIdQuery;
import com.angeldevs.subscriptionservice.domain.model.queries.GetPlanByIdQuery;
import com.angeldevs.subscriptionservice.domain.model.queries.GetSubscriptionByOrganizerIdQuery;
import com.angeldevs.subscriptionservice.domain.services.PaymentMethodQueryService;
import com.angeldevs.subscriptionservice.domain.services.PlanQueryService;
import com.angeldevs.subscriptionservice.domain.services.SubscriptionCommandService;
import com.angeldevs.subscriptionservice.domain.services.SubscriptionQueryService;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.subscription.CreateSubscriptionResource;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.subscription.GetSubscriptionByOrganizerResource;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.subscription.SubscriptionResource;
import com.angeldevs.subscriptionservice.interfaces.rest.transformers.paymentmethod.PaymentMethodResourceFromEntityAssembler;
import com.angeldevs.subscriptionservice.interfaces.rest.transformers.plan.PlanResourceFromEntityAssembler;
import com.angeldevs.subscriptionservice.interfaces.rest.transformers.subscription.CreateSubscriptionCommandFromResourceAssembler;
import com.angeldevs.subscriptionservice.interfaces.rest.transformers.subscription.SubscriptionResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/subscription", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Subscription", description = "Subscription Management Endpoints")
public class SubscriptionController {

    private final SubscriptionCommandService subscriptionCommandService;
    private final SubscriptionQueryService subscriptionQueryService;

    private final PlanQueryService planQueryService;
    private final PaymentMethodQueryService paymentMethodQueryService;

    public SubscriptionController(SubscriptionCommandService subscriptionCommandService,
            SubscriptionQueryService subscriptionQueryService, PlanQueryService planQueryService,
            PaymentMethodQueryService paymentMethodQueryService) {
        this.subscriptionCommandService = subscriptionCommandService;
        this.subscriptionQueryService = subscriptionQueryService;
        this.planQueryService = planQueryService;
        this.paymentMethodQueryService = paymentMethodQueryService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionResource> createPlan(@RequestBody CreateSubscriptionResource resource) {

        var createSubscriptionCommand = CreateSubscriptionCommandFromResourceAssembler
                .toCommandFromResource(resource);

        var subscription = subscriptionCommandService.handle(createSubscriptionCommand);
        if (subscription == null)
            return ResponseEntity.badRequest().build();

        var subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription);
        return new ResponseEntity<>(subscriptionResource, HttpStatus.CREATED);
    }

    @GetMapping("/organizer-id/{organizerId}")
    public ResponseEntity<GetSubscriptionByOrganizerResource> getSubscriptionByOrganizerId(
            @PathVariable Long organizerId) {
        var query = new GetSubscriptionByOrganizerIdQuery(organizerId);
        var subscription = subscriptionQueryService.handle(query);

        if (subscription == null)
            return ResponseEntity.badRequest().build();

        var plan = planQueryService.handle(new GetPlanByIdQuery(subscription.getPlan().getId()));
        var paymentMethod = paymentMethodQueryService
                .handle(new GetPaymentMethodsByIdQuery(subscription.getPaymentMethod().getId()));

        var subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription);
        var planResource = PlanResourceFromEntityAssembler.toResourceFromEntity(plan);
        var paymentMethodResource = PaymentMethodResourceFromEntityAssembler.toResourceFromEntity(paymentMethod);

        return ResponseEntity.ok(new GetSubscriptionByOrganizerResource(
                subscriptionResource.id(),
                subscriptionResource.startDate(),
                subscriptionResource.endDate(),
                subscriptionResource.organizerId(),
                planResource,
                paymentMethodResource));
    }
}