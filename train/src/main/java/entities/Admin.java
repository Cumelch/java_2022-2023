package entities;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class Admin {
    int id;
    String email;
    String password;
}
