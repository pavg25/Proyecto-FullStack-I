package MicroServicio02.MicroServicio02.models;

import lombok.Data;

@Data
// Esta clase es la respuesta que se le enviara al cliente
public class User {
    private String id;
    private String email;
    private String nombre;
    
}
