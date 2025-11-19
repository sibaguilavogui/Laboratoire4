

# Ticket


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ticketID** | **Integer** |  |  [optional] |
|**title** | **String** |  |  [optional] |
|**priority** | [**PriorityEnum**](#PriorityEnum) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  [optional] |
|**assignedUser** | [**User**](User.md) |  |  [optional] |
|**descriptions** | [**List&lt;Description&gt;**](Description.md) |  |  [optional] |



## Enum: PriorityEnum

| Name | Value |
|---- | -----|
| BASSE | &quot;BASSE&quot; |
| MOYENNE | &quot;MOYENNE&quot; |
| HAUTE | &quot;HAUTE&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| OUVERT | &quot;OUVERT&quot; |
| ASSIGNE | &quot;ASSIGNE&quot; |
| VALIDATION | &quot;VALIDATION&quot; |
| TERMINE | &quot;TERMINE&quot; |



