package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.Description;
import org.openapitools.model.User;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Ticket
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.8.0")
public class Ticket {

  private Integer ticketID;

  private String title;

  /**
   * Gets or Sets priority
   */
  public enum PriorityEnum {
    BASSE("BASSE"),
    
    MOYENNE("MOYENNE"),
    
    HAUTE("HAUTE");

    private String value;

    PriorityEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PriorityEnum fromValue(String value) {
      for (PriorityEnum b : PriorityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private PriorityEnum priority;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    OUVERT("OUVERT"),
    
    ASSIGNE("ASSIGNE"),
    
    VALIDATION("VALIDATION"),
    
    TERMINE("TERMINE");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private User assignedUser;

  @Valid
  private List<@Valid Description> descriptions = new ArrayList<>();

  public Ticket ticketID(Integer ticketID) {
    this.ticketID = ticketID;
    return this;
  }

  /**
   * Get ticketID
   * @return ticketID
   */
  
  @Schema(name = "ticketID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ticketID")
  public Integer getTicketID() {
    return ticketID;
  }

  public void setTicketID(Integer ticketID) {
    this.ticketID = ticketID;
  }

  public Ticket title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Ticket priority(PriorityEnum priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   * @return priority
   */
  
  @Schema(name = "priority", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priority")
  public PriorityEnum getPriority() {
    return priority;
  }

  public void setPriority(PriorityEnum priority) {
    this.priority = priority;
  }

  public Ticket status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Ticket assignedUser(User assignedUser) {
    this.assignedUser = assignedUser;
    return this;
  }

  /**
   * Get assignedUser
   * @return assignedUser
   */
  @Valid 
  @Schema(name = "assignedUser", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assignedUser")
  public User getAssignedUser() {
    return assignedUser;
  }

  public void setAssignedUser(User assignedUser) {
    this.assignedUser = assignedUser;
  }

  public Ticket descriptions(List<@Valid Description> descriptions) {
    this.descriptions = descriptions;
    return this;
  }

  public Ticket addDescriptionsItem(Description descriptionsItem) {
    if (this.descriptions == null) {
      this.descriptions = new ArrayList<>();
    }
    this.descriptions.add(descriptionsItem);
    return this;
  }

  /**
   * Get descriptions
   * @return descriptions
   */
  @Valid 
  @Schema(name = "descriptions", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("descriptions")
  public List<@Valid Description> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<@Valid Description> descriptions) {
    this.descriptions = descriptions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return Objects.equals(this.ticketID, ticket.ticketID) &&
        Objects.equals(this.title, ticket.title) &&
        Objects.equals(this.priority, ticket.priority) &&
        Objects.equals(this.status, ticket.status) &&
        Objects.equals(this.assignedUser, ticket.assignedUser) &&
        Objects.equals(this.descriptions, ticket.descriptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ticketID, title, priority, status, assignedUser, descriptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ticket {\n");
    sb.append("    ticketID: ").append(toIndentedString(ticketID)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    assignedUser: ").append(toIndentedString(assignedUser)).append("\n");
    sb.append("    descriptions: ").append(toIndentedString(descriptions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

