package com.angeldevs.subscriptionservice.interfaces.rest;

import com.angeldevs.subscriptionservice.domain.model.queries.GetPaymentMethodsByIdQuery;
import com.angeldevs.subscriptionservice.domain.services.PaymentMethodCommandService;
import com.angeldevs.subscriptionservice.domain.services.PaymentMethodQueryService;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.paymentmethod.CreatePaymentMethodResource;
import com.angeldevs.subscriptionservice.interfaces.rest.resources.paymentmethod.PaymentMethodResource;
import com.angeldevs.subscriptionservice.interfaces.rest.transformers.paymentmethod.CreatePaymentMethodCommandFromResourceAssembler;
import com.angeldevs.subscriptionservice.interfaces.rest.transformers.paymentmethod.PaymentMethodResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/payment-method", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Payment Method", description = "Payment Method Management Endpoints")
public class PaymentMethodController {

    private final PaymentMethodCommandService paymentMethodCommandService;
    private final PaymentMethodQueryService paymentMethodQueryService;

    public PaymentMethodController(PaymentMethodCommandService paymentMethodCommandService, PaymentMethodQueryService paymentMethodQueryService) {
        this.paymentMethodCommandService = paymentMethodCommandService;
        this.paymentMethodQueryService = paymentMethodQueryService;
    }

    @PostMapping
    public ResponseEntity<PaymentMethodResource> createPayment(@RequestBody CreatePaymentMethodResource resource) {

        var createPaymentCommand = CreatePaymentMethodCommandFromResourceAssembler
                .toCommandFromResource(resource);
        var paymentMethod = paymentMethodCommandService.handle(createPaymentCommand);
        if (paymentMethod == null)
            return ResponseEntity.badRequest().build();

        var paymentResource = PaymentMethodResourceFromEntityAssembler.toResourceFromEntity(paymentMethod);
        return new ResponseEntity<>(paymentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{paymentMethodId}")
    public ResponseEntity<PaymentMethodResource> getById(@PathVariable Long paymentMethodId) {

        var paymentMethod = paymentMethodQueryService.handle(new GetPaymentMethodsByIdQuery(paymentMethodId));

        var paymentMethodResource = PaymentMethodResourceFromEntityAssembler.toResourceFromEntity(paymentMethod);

        return ResponseEntity.ok(paymentMethodResource);
    }

}
