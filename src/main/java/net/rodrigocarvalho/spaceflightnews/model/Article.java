package net.rodrigocarvalho.spaceflightnews.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Article {

    @Id
    private String id;

    private boolean featured;

    @NotEmpty
    private String title;

    @NotEmpty
    private String url;

    private String imageUrl;

    private String newsSite;
    private String summary;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publishedAt;

    private Launch[] launches;
    private Event[] events;

}
