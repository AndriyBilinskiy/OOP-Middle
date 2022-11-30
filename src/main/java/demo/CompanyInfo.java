package demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Setter
@Getter
public class CompanyInfo {
    @Id @GeneratedValue
    private int id;
    private String name;
    @Column(unique = true)
    private String twitter;
    private String facebook;
    private JSONObject logo;
    private JSONObject icon;
    private String employees;
    private String address;

}
