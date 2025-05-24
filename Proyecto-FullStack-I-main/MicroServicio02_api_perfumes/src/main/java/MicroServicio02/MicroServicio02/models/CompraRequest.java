package MicroServicio02.MicroServicio02.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CompraRequest {
    @NotBlank
    private String idPerfume;

    private int idUsuario;

    @NotBlank
    private String numeroTarjeta;
    
}
