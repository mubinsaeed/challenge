package com.tlx.portal.classes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
@NotBlank(message = "Message cannot be blank")
@NotNull(message = "Field message is required")
    private String message;
    private Date date;
    @NotBlank(message = "title cannot be blank")
    @NotNull(message = "Field title is required")
    private String title;
    @NotNull(message = "Read attribute cannot be blank")
    private boolean read;
    private Long userId;


}
