package entities;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class Order {
    int id;
    String date;
    boolean status;
}
