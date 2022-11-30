package demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

@NoArgsConstructor
@Setter
@Getter
public class CompanyInfo {
    private String name;
    private String twitter;
    private String facebook;
    private JSONObject logo;
    private JSONObject icon;
    private String employees;
    private String address;

}
