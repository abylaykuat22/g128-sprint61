package kz.bitlab.g128sprinttask61.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "APPLICATION_REQUESTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userName;
  private String courseName;
  private String commentary;
  private String phone;
  private boolean handled; //обработано или нет
}
