package com.springuni.forgetme.datahandler.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.springuni.forgetme.datahandler.service.WebhookService;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebhookController {

  private final WebhookService webhookService;

  public WebhookController(WebhookService webhookService) {
    this.webhookService = webhookService;
  }

  @PostMapping(
      path = "/webhook/{dataHandlerId}/{dataHandlerKey}",
      consumes = APPLICATION_JSON_VALUE
  )
  public HttpEntity submitData(
      @PathVariable UUID dataHandlerId, @PathVariable UUID dataHandlerKey,
      @RequestBody Map<String, Object> jsonData) {

    webhookService.submitData(dataHandlerId, dataHandlerKey, jsonData);

    return ResponseEntity.accepted().build();
  }

}
