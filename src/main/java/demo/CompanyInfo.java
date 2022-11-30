package demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class CompanyInfo {
    @Id @GeneratedValue
    private int id;
    private String name;
    @Column(unique = true)
    private String twitter;
    private String facebook;
    private String logo;
    private String icon;
    private String employees;
    private String address;

}
