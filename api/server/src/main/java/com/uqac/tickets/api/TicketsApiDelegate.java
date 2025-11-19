package com.uqac.tickets.api;

import com.uqac.tickets.model.NewTicket;
import com.uqac.tickets.model.Ticket;
import com.uqac.tickets.model.UpdateTicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link TicketsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.8.0")
public interface TicketsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /tickets : Liste tous les tickets
     *
     * @return Liste des tickets (status code 200)
     * @see TicketsApi#ticketsGet
     */
    default ResponseEntity<List<Ticket>> ticketsGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"title\" : \"title\", \"priority\" : \"BASSE\", \"assignedUser\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"descriptions\" : [ { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" }, { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" } ], \"ticketID\" : 0, \"status\" : \"OUVERT\" }, { \"title\" : \"title\", \"priority\" : \"BASSE\", \"assignedUser\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"descriptions\" : [ { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" }, { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" } ], \"ticketID\" : 0, \"status\" : \"OUVERT\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /tickets/{id} : Récupère un ticket par ID
     *
     * @param id  (required)
     * @return Ticket trouvé (status code 200)
     *         or Ticket introuvable (status code 404)
     * @see TicketsApi#ticketsIdGet
     */
    default ResponseEntity<Ticket> ticketsIdGet(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"title\" : \"title\", \"priority\" : \"BASSE\", \"assignedUser\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"descriptions\" : [ { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" }, { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" } ], \"ticketID\" : 0, \"status\" : \"OUVERT\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /tickets/{id} : Met à jour un ticket (statut, priorité, assignation)
     *
     * @param id  (required)
     * @param updateTicket  (required)
     * @return Ticket mis à jour (status code 200)
     * @see TicketsApi#ticketsIdPut
     */
    default ResponseEntity<Ticket> ticketsIdPut(Integer id,
        UpdateTicket updateTicket) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"title\" : \"title\", \"priority\" : \"BASSE\", \"assignedUser\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"descriptions\" : [ { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" }, { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" } ], \"ticketID\" : 0, \"status\" : \"OUVERT\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /tickets : Crée un nouveau ticket
     *
     * @param newTicket  (required)
     * @return Ticket créé (status code 201)
     * @see TicketsApi#ticketsPost
     */
    default ResponseEntity<Ticket> ticketsPost(NewTicket newTicket) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"title\" : \"title\", \"priority\" : \"BASSE\", \"assignedUser\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"descriptions\" : [ { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" }, { \"addedBy\" : { \"role\" : \"role\", \"name\" : \"name\", \"userID\" : 6, \"email\" : \"email\" }, \"id\" : 1, \"text\" : \"text\", \"type\" : \"TEXTE\", \"uri\" : \"uri\" } ], \"ticketID\" : 0, \"status\" : \"OUVERT\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
