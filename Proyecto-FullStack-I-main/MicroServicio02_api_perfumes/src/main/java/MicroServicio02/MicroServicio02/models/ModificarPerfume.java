package MicroServicio02.MicroServicio02.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

public @Data class ModificarPerfume {
    @Min(1)
    @Max(99999)
    private int precio;
    
}
