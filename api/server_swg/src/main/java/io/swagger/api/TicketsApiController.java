package io.swagger.api;

import io.swagger.model.NewTicket;
import io.swagger.model.Ticket;
import io.swagger.model.UpdateTicket;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-29T17:50:22.611548500-04:00[America/Toronto]")
@RestController
public class TicketsApiController implements TicketsApi {

    private static final Logger log = LoggerFactory.getLogger(TicketsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TicketsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Ticket>> ticketsGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Ticket>>(objectMapper.readValue("[ {\r\n  \"title\" : \"title\",\r\n  \"priority\" : \"BASSE\",\r\n  \"assignedUser\" : {\r\n    \"role\" : \"role\",\r\n    \"name\" : \"name\",\r\n    \"userID\" : 6,\r\n    \"email\" : \"email\"\r\n  },\r\n  \"descriptions\" : [ {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  }, {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  } ],\r\n  \"ticketID\" : 0,\r\n  \"status\" : \"OUVERT\"\r\n}, {\r\n  \"title\" : \"title\",\r\n  \"priority\" : \"BASSE\",\r\n  \"assignedUser\" : {\r\n    \"role\" : \"role\",\r\n    \"name\" : \"name\",\r\n    \"userID\" : 6,\r\n    \"email\" : \"email\"\r\n  },\r\n  \"descriptions\" : [ {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  }, {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  } ],\r\n  \"ticketID\" : 0,\r\n  \"status\" : \"OUVERT\"\r\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Ticket>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ticket> ticketsIdGet(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("{\r\n  \"title\" : \"title\",\r\n  \"priority\" : \"BASSE\",\r\n  \"assignedUser\" : {\r\n    \"role\" : \"role\",\r\n    \"name\" : \"name\",\r\n    \"userID\" : 6,\r\n    \"email\" : \"email\"\r\n  },\r\n  \"descriptions\" : [ {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  }, {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  } ],\r\n  \"ticketID\" : 0,\r\n  \"status\" : \"OUVERT\"\r\n}", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ticket>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ticket> ticketsIdPut(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UpdateTicket body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("{\r\n  \"title\" : \"title\",\r\n  \"priority\" : \"BASSE\",\r\n  \"assignedUser\" : {\r\n    \"role\" : \"role\",\r\n    \"name\" : \"name\",\r\n    \"userID\" : 6,\r\n    \"email\" : \"email\"\r\n  },\r\n  \"descriptions\" : [ {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  }, {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  } ],\r\n  \"ticketID\" : 0,\r\n  \"status\" : \"OUVERT\"\r\n}", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ticket>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ticket> ticketsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody NewTicket body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("{\r\n  \"title\" : \"title\",\r\n  \"priority\" : \"BASSE\",\r\n  \"assignedUser\" : {\r\n    \"role\" : \"role\",\r\n    \"name\" : \"name\",\r\n    \"userID\" : 6,\r\n    \"email\" : \"email\"\r\n  },\r\n  \"descriptions\" : [ {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  }, {\r\n    \"id\" : 1,\r\n    \"text\" : \"text\",\r\n    \"type\" : \"TEXTE\",\r\n    \"uri\" : \"uri\"\r\n  } ],\r\n  \"ticketID\" : 0,\r\n  \"status\" : \"OUVERT\"\r\n}", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ticket>(HttpStatus.NOT_IMPLEMENTED);
    }

}
