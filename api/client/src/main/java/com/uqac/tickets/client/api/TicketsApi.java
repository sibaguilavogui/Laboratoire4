package com.uqac.tickets.client.api;

import com.uqac.tickets.client.ApiClient;
import com.uqac.tickets.client.BaseApi;

import com.uqac.tickets.client.model.NewTicket;
import com.uqac.tickets.client.model.Ticket;
import com.uqac.tickets.client.model.UpdateTicket;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-11-12T23:31:52.752351400-05:00[America/Toronto]", comments = "Generator version: 7.8.0")
public class TicketsApi extends BaseApi {

    public TicketsApi() {
        super(new ApiClient());
    }

    public TicketsApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Liste tous les tickets
     * 
     * <p><b>200</b> - Liste des tickets
     * @return List&lt;Ticket&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Ticket> ticketsGet() throws RestClientException {
        return ticketsGetWithHttpInfo().getBody();
    }

    /**
     * Liste tous les tickets
     * 
     * <p><b>200</b> - Liste des tickets
     * @return ResponseEntity&lt;List&lt;Ticket&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Ticket>> ticketsGetWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<List<Ticket>> localReturnType = new ParameterizedTypeReference<List<Ticket>>() {};
        return apiClient.invokeAPI("/tickets", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Récupère un ticket par ID
     * 
     * <p><b>200</b> - Ticket trouvé
     * <p><b>404</b> - Ticket introuvable
     * @param id  (required)
     * @return Ticket
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Ticket ticketsIdGet(Integer id) throws RestClientException {
        return ticketsIdGetWithHttpInfo(id).getBody();
    }

    /**
     * Récupère un ticket par ID
     * 
     * <p><b>200</b> - Ticket trouvé
     * <p><b>404</b> - Ticket introuvable
     * @param id  (required)
     * @return ResponseEntity&lt;Ticket&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Ticket> ticketsIdGetWithHttpInfo(Integer id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling ticketsIdGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Ticket> localReturnType = new ParameterizedTypeReference<Ticket>() {};
        return apiClient.invokeAPI("/tickets/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Met à jour un ticket (statut, priorité, assignation)
     * 
     * <p><b>200</b> - Ticket mis à jour
     * @param id  (required)
     * @param updateTicket  (required)
     * @return Ticket
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Ticket ticketsIdPut(Integer id, UpdateTicket updateTicket) throws RestClientException {
        return ticketsIdPutWithHttpInfo(id, updateTicket).getBody();
    }

    /**
     * Met à jour un ticket (statut, priorité, assignation)
     * 
     * <p><b>200</b> - Ticket mis à jour
     * @param id  (required)
     * @param updateTicket  (required)
     * @return ResponseEntity&lt;Ticket&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Ticket> ticketsIdPutWithHttpInfo(Integer id, UpdateTicket updateTicket) throws RestClientException {
        Object localVarPostBody = updateTicket;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling ticketsIdPut");
        }
        
        // verify the required parameter 'updateTicket' is set
        if (updateTicket == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateTicket' when calling ticketsIdPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Ticket> localReturnType = new ParameterizedTypeReference<Ticket>() {};
        return apiClient.invokeAPI("/tickets/{id}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Crée un nouveau ticket
     * 
     * <p><b>201</b> - Ticket créé
     * @param newTicket  (required)
     * @return Ticket
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Ticket ticketsPost(NewTicket newTicket) throws RestClientException {
        return ticketsPostWithHttpInfo(newTicket).getBody();
    }

    /**
     * Crée un nouveau ticket
     * 
     * <p><b>201</b> - Ticket créé
     * @param newTicket  (required)
     * @return ResponseEntity&lt;Ticket&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Ticket> ticketsPostWithHttpInfo(NewTicket newTicket) throws RestClientException {
        Object localVarPostBody = newTicket;
        
        // verify the required parameter 'newTicket' is set
        if (newTicket == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'newTicket' when calling ticketsPost");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Ticket> localReturnType = new ParameterizedTypeReference<Ticket>() {};
        return apiClient.invokeAPI("/tickets", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
