package MicroServicio02.MicroServicio02.models;

import lombok.Data;

@Data
// Esta clase es la respuesta que se le enviara al cliente
public class CompraResponse {

    private String idBoleta;
    private String mensaje;
    private Boolean exito;

    private Integer stockRestante;
    
}
