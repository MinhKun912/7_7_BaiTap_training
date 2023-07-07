package ra.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployee {
    private int id;
    private String name;
    private String email;
    private String department;
    List<String> roles;

}
