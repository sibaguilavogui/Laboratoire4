# TicketsApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**ticketsGet**](TicketsApi.md#ticketsGet) | **GET** /tickets | Liste tous les tickets |
| [**ticketsIdGet**](TicketsApi.md#ticketsIdGet) | **GET** /tickets/{id} | Récupère un ticket par ID |
| [**ticketsIdPut**](TicketsApi.md#ticketsIdPut) | **PUT** /tickets/{id} | Met à jour un ticket (statut, priorité, assignation) |
| [**ticketsPost**](TicketsApi.md#ticketsPost) | **POST** /tickets | Crée un nouveau ticket |



## ticketsGet

> List&lt;Ticket&gt; ticketsGet()

Liste tous les tickets

### Example

```java
// Import classes:
import com.uqac.tickets.client.ApiClient;
import com.uqac.tickets.client.ApiException;
import com.uqac.tickets.client.Configuration;
import com.uqac.tickets.client.models.*;
import com.uqac.tickets.client.api.TicketsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        TicketsApi apiInstance = new TicketsApi(defaultClient);
        try {
            List<Ticket> result = apiInstance.ticketsGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TicketsApi#ticketsGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;Ticket&gt;**](Ticket.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Liste des tickets |  -  |


## ticketsIdGet

> Ticket ticketsIdGet(id)

Récupère un ticket par ID

### Example

```java
// Import classes:
import com.uqac.tickets.client.ApiClient;
import com.uqac.tickets.client.ApiException;
import com.uqac.tickets.client.Configuration;
import com.uqac.tickets.client.models.*;
import com.uqac.tickets.client.api.TicketsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        TicketsApi apiInstance = new TicketsApi(defaultClient);
        Integer id = 56; // Integer | 
        try {
            Ticket result = apiInstance.ticketsIdGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TicketsApi#ticketsIdGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |

### Return type

[**Ticket**](Ticket.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Ticket trouvé |  -  |
| **404** | Ticket introuvable |  -  |


## ticketsIdPut

> Ticket ticketsIdPut(id, updateTicket)

Met à jour un ticket (statut, priorité, assignation)

### Example

```java
// Import classes:
import com.uqac.tickets.client.ApiClient;
import com.uqac.tickets.client.ApiException;
import com.uqac.tickets.client.Configuration;
import com.uqac.tickets.client.models.*;
import com.uqac.tickets.client.api.TicketsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        TicketsApi apiInstance = new TicketsApi(defaultClient);
        Integer id = 56; // Integer | 
        UpdateTicket updateTicket = new UpdateTicket(); // UpdateTicket | 
        try {
            Ticket result = apiInstance.ticketsIdPut(id, updateTicket);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TicketsApi#ticketsIdPut");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |
| **updateTicket** | [**UpdateTicket**](UpdateTicket.md)|  | |

### Return type

[**Ticket**](Ticket.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Ticket mis à jour |  -  |


## ticketsPost

> Ticket ticketsPost(newTicket)

Crée un nouveau ticket

### Example

```java
// Import classes:
import com.uqac.tickets.client.ApiClient;
import com.uqac.tickets.client.ApiException;
import com.uqac.tickets.client.Configuration;
import com.uqac.tickets.client.models.*;
import com.uqac.tickets.client.api.TicketsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        TicketsApi apiInstance = new TicketsApi(defaultClient);
        NewTicket newTicket = new NewTicket(); // NewTicket | 
        try {
            Ticket result = apiInstance.ticketsPost(newTicket);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TicketsApi#ticketsPost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **newTicket** | [**NewTicket**](NewTicket.md)|  | |

### Return type

[**Ticket**](Ticket.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Ticket créé |  -  |

