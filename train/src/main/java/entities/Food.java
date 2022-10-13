package entities;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class Food {
    int id;
    String name;
    int cost;
}
