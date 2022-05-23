package net.rodrigocarvalho.spaceflightnews.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Event {

    @Id
    private Long id;
    private String provider;

}
