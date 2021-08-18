```mermaid
sequenceDiagram 
    participant CreadorReserva
    participant SistemaDeMensajería
    Note over CreadorReserva,SistemaDeMensajería: Incluir CU8 y CU9
    Note over CreadorReserva,SistemaDeMensajería: Incluir CU7
 
 
    alt Se quiere modificar la reserva
        CreadorReserva ->>+ SistemaDeMensajería: ModificarDatosReserva(fecha_inicio, fecha_termino, estado)
        SistemaDeMensajería ->>+ SistemaDeMensajería: VerificarDisponibilidad(fecha_inicio, fecha_termino,estado)
    else Desiste de crear la reserva
        SistemaDeMensajería -->>+ CreadorReserva: VolverMenuInicial()
    end
 
    alt No hay disponibilidad
        SistemaDeMensajería ->>+ SistemaDeMensajería: BuscarDisponibilidadOtrosHoteles(fecha_inicio, fecha_termino,estado)
        SistemaDeMensajería -->>+ CreadorReserva: NotificarDisponibilidad()
        CreadorReserva ->>+ SistemaDeMensajería: ModificarDatosReserva(fecha_inicio, fecha_termino, estado)
    else Hay disponibilidad (en hotel de su conveniencia)
        CreadorReserva ->>+ SistemaDeMensajería: ModificarDatosReserva(fecha_inicio, fecha_termino, estado)
    end
 
    CreadorReserva ->>+ SistemaDeMensajería: RegistrarReserva(fecha_inicio, fecha_termino, estado)
 
    Note over CreadorReserva,SistemaDeMensajería: Incluir CU10


sequenceDiagram 
    participant Huésped
    participant Cliente
    participant Recepcionista
    participant SGH
    participant SistemaDeFacturación
    
 
    alt Huésped tiene reserva
 
        alt Ninguna reserva coincide con la información del Huésped
            Note over Huésped, SistemaDeFacturación: Incluir CU1
            Huésped ->>+ Recepcionista: EntregarDatosPersonales(Nombre, mail, teléfono)
        Else Hay una reserva corcondante con la información del Huésped
            Huésped ->>+ Recepcionista: EntregarInformacionReserva(codigo)
            Recepcionista ->>+ SGH: LocalizarReserva(codigo)
        End
 
    else Huésped no tiene reserva    
 
        Note over Huésped, SistemaDeFacturación: Incluir CU1
 
        alt Hay reservas aún no tomadas
            SGH -->+ Recepcionista: MostrarHabitacionesDisponibles()
        Else No hay reservas aún no tomadas
            Note over Huésped, SistemaDeFacturación: Incluir CU1
            Huésped ->>+ Recepcionista: EntregarDatosPersonales(Nombre, mail, teléfono)
        End
 
        Recepcionista ->>+ SGH: SeleccionarHabitación()
 
        alt Huésped no desea modificar datos de la reserva
            Huésped ->>+ Recepcionista: EntregarDatosPersonales(Nombre, mail, teléfono)
        Else Huésped requiere modificar datos de la reserva
            Recepcionista -->+ Cliente: RevisarPermisoCambioDatosReservaHuésped(Nombre_Huésped)
            alt Huésped no tiene permiso para cambiar datos de la reserva
                Recepcionista -->+ Huésped: InformarProhibición()
                Huésped ->>+ Recepcionista: EntregarDatosPersonales(Nombre, mail, teléfono)
            Else Huésped con permisos
                Note over Huésped, SistemaDeFacturación: Incluir CU2
                Huésped ->>+ Recepcionista: EntregarDatosPersonales(Nombre, mail, teléfono)
            End
        End
 
        Recepcionista ->>+ SGH: EntregarDatosPersonales(Nombre, mail, teléfono)
        SGH ->>+ SGH: AsignarHabitación(Nombre_Huesped)
        SGH ->>+ SistemaDeFacturación: FacturarEstadía(Nombre_Huesped)
    end


```
