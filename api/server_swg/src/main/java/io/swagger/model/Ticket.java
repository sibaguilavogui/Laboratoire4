package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Description;
import io.swagger.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ticket
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-29T17:50:22.611548500-04:00[America/Toronto]")


public class Ticket   {
  @JsonProperty("ticketID")
  private Integer ticketID = null;

  @JsonProperty("title")
  private String title = null;

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

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PriorityEnum fromValue(String text) {
      for (PriorityEnum b : PriorityEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("priority")
  private PriorityEnum priority = null;

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

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("assignedUser")
  private User assignedUser = null;

  @JsonProperty("descriptions")
  @Valid
  private List<Description> descriptions = null;

  public Ticket ticketID(Integer ticketID) {
    this.ticketID = ticketID;
    return this;
  }

  /**
   * Get ticketID
   * @return ticketID
   **/
  @Schema(description = "")
  
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
   **/
  @Schema(description = "")
  
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
   **/
  @Schema(description = "")
  
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
   **/
  @Schema(description = "")
  
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
   **/
  @Schema(description = "")
  
    @Valid
    public User getAssignedUser() {
    return assignedUser;
  }

  public void setAssignedUser(User assignedUser) {
    this.assignedUser = assignedUser;
  }

  public Ticket descriptions(List<Description> descriptions) {
    this.descriptions = descriptions;
    return this;
  }

  public Ticket addDescriptionsItem(Description descriptionsItem) {
    if (this.descriptions == null) {
      this.descriptions = new ArrayList<Description>();
    }
    this.descriptions.add(descriptionsItem);
    return this;
  }

  /**
   * Get descriptions
   * @return descriptions
   **/
  @Schema(description = "")
      @Valid
    public List<Description> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<Description> descriptions) {
    this.descriptions = descriptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
