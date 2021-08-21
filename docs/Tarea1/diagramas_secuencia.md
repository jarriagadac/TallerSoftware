# Tarea 1.2

## (A) Hacer Reservas

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Hacer Reserva (CU1). Para ello considerar solamente los casos de uso incluidos Identificar Cliente en Recepción (CU8) y Alta Cliente.

![HacerReservas](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlTWVuc2FqZXLDrWFcblxuICAgICUlIDFcbiAgICBhbHQgY2xpZW50ZSBubyByZWdpc3RyYWRvXG4gICAgICAgIE5vdGUgb3ZlciBDcmVhZG9yUmVzZXJ2YSxTR0g6IEFsdGEgZGUgQ2xpZW50ZVxuICAgIGVsc2UgY2xpZW50ZSByZWdpc3RyYWRvXG4gICAgICAgIE5vdGUgb3ZlciBDcmVhZG9yUmVzZXJ2YSxTR0g6IEluY2x1aXIgSWRlbnRpZmljYXIgQ2xpZW50ZSAoQ1U4fENVOSlcbiAgICBlbmRcblxuICAgICUlIDIgeSAzXG4gICAgbG9vcFxuICAgICAgICBDcmVhZG9yUmVzZXJ2YSAtPj4gU0dIOiBkaXNwb25pYmlsaWRhZCA6PSBjb25maXJtYXJEaXNwb25pYmlsaWRhZChpZF9ob3RlbDogaW50LCBpZF90aXBvX2hhYml0YWNpb246IGludCwgZmluaWNpbzogZGF0ZSwgZmZpbjogZGF0ZSkgOiBCb29sZWFuXG4gICAgICAgIG9wdCBubyBoYXkgZGlzcG9uaWJpbGlkYWRcbiAgICAgICAgICAgIENyZWFkb3JSZXNlcnZhIC0-PiBTR0g6IGFsdGVybmF0aXZhcyA6PSBidXNjYXJBbHRlcm5hdGl2YXMocGFpczogc3RyLCBpZF90aXBvX2hhYml0YWNpb246IGludCwgZmluaWNpbzogZGF0ZSwgZmZpbjogZGF0ZSkgOiBMaXN0PEhvdGVsPlxuICAgICAgICBlbmRcbiAgICBlbmRcbiAgICBcbiAgICAlJTRcbiAgICBDcmVhZG9yUmVzZXJ2YSAtPj4gU0dIOiByZWdpc3RyYXJSZXNlcnZhKGlkX2hvdGVsOiBpbnQsIGlkX3RpcG9faGFiaXRhY2lvbjogaW50LCBmaW5pY2lvOiBkYXRlLCBmZmluOiBkYXRlLCBtb2RpZmljYWJsZTogYm9vbClcblxuICAgIE5vdGUgb3ZlciBTR0gsU2lzdGVtYURlTWVuc2FqZXLDrWE6IEluY2x1aXIgQ29uZmlybWFyIFJlc2VydmEgKENVMTApXG5cblxuIiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

```
sequenceDiagram 
    participant CreadorReserva
    participant SGH
    participant SistemaDeMensajería

    %% 1
    alt cliente no registrado
        Note over CreadorReserva,SGH: Alta de Cliente
    else cliente registrado
        Note over CreadorReserva,SGH: Incluir Identificar Cliente (CU8|CU9)
    end

    %% 2 y 3
    loop
        CreadorReserva ->> SGH: disponibilidad := confirmarDisponibilidad(id_hotel: int, id_tipo_habitacion: int, finicio: date, ffin: date) : Boolean
        opt no hay disponibilidad
            CreadorReserva ->> SGH: alternativas := buscarAlternativas(pais: str, id_tipo_habitacion: int, finicio: date, ffin: date) : List<Hotel>
        end
    end
    
    %%4
    CreadorReserva ->> SGH: registrarReserva(id_hotel: int, id_tipo_habitacion: int, finicio: date, ffin: date, modificable: bool)

    Note over SGH,SistemaDeMensajería: Incluir Confirmar Reserva (CU10)
```

## (B) Modificar Reserva

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Modificar Reserva (CU2).

![ModificarReserva](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlTWVuc2FqZXLDrWFcbiAgICBOb3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU0dIOiBJZGVudGlmaWNhciBDbGllbnRlIChDVTh8Q1U5KVxuICAgIE5vdGUgb3ZlciBDcmVhZG9yUmVzZXJ2YSxTR0g6IElkZW50aWZpY2FyIFJlc2VydmEgZGUgQ2xpZW50ZSAoQ1U3KVxuXG4gICAgJSUgM1xuICAgIGxvb3AgbW9kaWZpY2FyIHJlc2VydmFcbiAgICAgICAgbG9vcCBlbmNvbnRyYXIgaG90ZWwgZGlzcG9uaWJsZVxuICAgICAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogZGlzcG9uaWJpbGlkYWQgOj0gY29uZmlybWFyRGlzcG9uaWJpbGlkYWQoaWRfaG90ZWw6IGludCwgaWRfdGlwb19oYWJpdGFjaW9uOiBpbnQsIGZpbmljaW86IGRhdGUsIGZmaW46IGRhdGUpIDogQm9vbFxuICAgICAgICAgICAgb3B0IG5vIGhheSBkaXNwb25pYmlsaWRhZFxuICAgICAgICAgICAgICAgIENyZWFkb3JSZXNlcnZhIC0-PiBTR0g6IGFsdGVybmF0aXZhcyA6PSBidXNjYXJBbHRlcm5hdGl2YXMocGFpczogc3RyLCBpZF90aXBvX2hhYml0YWNpb246IGludCwgZmluaWNpbzogZGF0ZSwgZmZpbjogZGF0ZSkgOiBMaXN0PEhvdGVsPlxuICAgICAgICAgICAgZW5kXG4gICAgICAgIGVuZFxuXG4gICAgICAgIG9wdCBjb25maXJtYSBtb2RpZmljYWNpb25cbiAgICAgICAgICAgIENyZWFkb3JSZXNlcnZhIC0-PiBTR0g6IG1vZGlmaWNhclJlc2VydmEoaWRfaG90ZWw6IGludCwgaWRfdGlwb19oYWJpdGFjaW9uOiBpbnQsIGZpbmljaW86IGRhdGUsIGZmaW46IGRhdGUsIG1vZGlmaWNhYmxlOiBib29sKVxuICAgICAgICAgICAgTm90ZSBvdmVyIFNHSCxTaXN0ZW1hRGVNZW5zYWplcsOtYTogQ29uZmlybWFyIFJlc2VydmEgKENVMTApXG4gICAgICAgIGVuZFxuICAgIGVuZCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)

```
sequenceDiagram 
    participant CreadorReserva
    participant SGH
    participant SistemaDeMensajería
    Note over CreadorReserva,SGH: Identificar Cliente (CU8|CU9)
    Note over CreadorReserva,SGH: Identificar Reserva de Cliente (CU7)

    %% 3
    loop modificar reserva
        loop encontrar hotel disponible
            CreadorReserva ->> SGH: disponibilidad := confirmarDisponibilidad(id_hotel: int, id_tipo_habitacion: int, finicio: date, ffin: date) : Bool
            opt no hay disponibilidad
                CreadorReserva ->> SGH: alternativas := buscarAlternativas(pais: str, id_tipo_habitacion: int, finicio: date, ffin: date) : List<Hotel>
            end
        end

        opt confirma modificacion
            CreadorReserva ->> SGH: modificarReserva(id_hotel: int, id_tipo_habitacion: int, finicio: date, ffin: date, modificable: bool)
            Note over SGH,SistemaDeMensajería: Confirmar Reserva (CU10)
        end
    end
```

## (C) Tomar Reserva

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Tomar Reserva (CU4).

![TomarReserva](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IFJlY2VwY2lvbmlzdGFcbiAgICBwYXJ0aWNpcGFudCBTR0hcbiAgICBwYXJ0aWNpcGFudCBTaXN0ZW1hTWVuc2FqZXJpYVxuICAgIHBhcnRpY2lwYW50IFNpc3RlbWFEZUZhY3R1cmFjacOzblxuICAgIFxuICAgIFJlY2VwY2lvbmlzdGEgLT4-IFNHSDogcmVzZXJ2YXMgOj0gb2J0ZW5lclJlc2VydmFzKE5PX1RPTUFEQSlcbiAgICBcbiAgICBvcHQgbm8gaGF5IHJlc2VydmFzIG8gbm8gaGF5IHVuYSByZXNlcnZhIHBhcmEgZWwgY2xpZW50ZVxuICAgICAgICBOb3RlIG92ZXIgUmVjZXBjaW9uaXN0YSwgU2lzdGVtYU1lbnNhamVyaWE6IEluY2x1aXIgSGFjZXIgUmVzZXJ2YSAoQ1UxKVxuICAgIGVuZFxuXG4gICAgUmVjZXBjaW9uaXN0YSAtPj4gU0dIOiByZXNlcnZhIDo9IG9idGVuZXJSZXNlcnZhKGlkX3Jlc2VydmE6IGludCk6IFJlc2VydmFcblxuICAgIG9wdCBtb2RpZmljYXIgZGF0b3MgZGUgbGEgcmVzZXJ2YSB5IHJlc2VydmEgbW9kaWZpY2FibGVcbiAgICAgICAgTm90ZSBvdmVyIFJlY2VwY2lvbmlzdGEsIFNpc3RlbWFNZW5zYWplcmlhOiBJbmNsdWlyIE1vZGlmaWNhciBSZXNlcnZhIChDVTIpXG4gICAgZW5kXG5cbiAgICBvcHQgYXNpZ25hciBoYWJpdGFjacOzbiBhbCBodWVzcGVkXG4gICAgICAgIFJlY2VwY2lvbmlzdGEgLT4-IFNHSDogaGFiaXRhY2lvbiA6PSBhc2lnbmFySGFiaXRhY2lvbihpZF9yZXNlcnZhOiBpbnQpOiBIYWJpdGFjaW9uXG4gICAgICAgIFNHSCAtPj4gU2lzdGVtYURlRmFjdHVyYWNpw7NuOiBub3RpZmljYXJJbmljaW9Fc3RhZGlhKGlkX3Jlc2VydmE6IGludClcbiAgICBlbmQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

```
sequenceDiagram 
    participant Recepcionista
    participant SGH
    participant SistemaMensajeria
    participant SistemaDeFacturación
    
    Recepcionista ->> SGH: reservas := obtenerReservas(NO_TOMADA)
    
    opt no hay reservas o no hay una reserva para el cliente
        Note over Recepcionista, SistemaMensajeria: Incluir Hacer Reserva (CU1)
    end

    Recepcionista ->> SGH: reserva := obtenerReserva(id_reserva: int): Reserva

    opt modificar datos de la reserva y reserva modificable
        Note over Recepcionista, SistemaMensajeria: Incluir Modificar Reserva (CU2)
    end

    opt asignar habitación al huesped
        Recepcionista ->> SGH: habitacion := asignarHabitacion(id_reserva: int): Habitacion
        SGH ->> SistemaDeFacturación: notificarInicioEstadia(id_reserva: int)
    end
```

## (D) Cancelar Reserva (para revisar) 

### Parte 1

Especificar el caso de uso Cancelar Reserva (CU3), tal como están especificados los otros casos de uso en el documento Especificación de Requisitos.

| Nombre | Cancelar Reserva (CU3) |
|-|-|
| Actores | Creador de Reserva, Sistema de Mensajería |
| Actividades | Cancelar Reserva, Confirmar Cancelación de Reserva |
| Sinopsis | Este caso de uso comienza cuando el Creador de Reserva solicita cancelar una reserva. El sistema chequea que la reserva esté en plazo para ser cancelada. Si hay costos asociados a la reserva estos se facturan. |
| Curso Típico de Eventos | |
|                         | (1) curso típico |
| Extensiones | |
| | (2) extensiones |

> (1) curso títico
>
> 1. Incluir Identificar Cliente (CU8|CU9)
> 2. Incluir Identificar Reserva de Cliente (CU7)
> 3. Creador de Reserva cancela reserva.
> 4. Sistema confirma la cancelación de la reserva.
> 5. Incluir Confirmar Reserva (CU10)

> (2) extensiones
>
> 4a. Creador de Reserva decide no cancelar la reserva.
>       1. Stop

### Parte 2

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Cancelar Reserva (CU3).

![CancelarReserva](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlTWVuc2FqZXLDrWFcbiAgICBOb3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU0dIOiBJZGVudGlmaWNhciBDbGllbnRlIChDVTh8Q1U5KVxuICAgIE5vdGUgb3ZlciBDcmVhZG9yUmVzZXJ2YSxTR0g6IElkZW50aWZpY2FyIFJlc2VydmEgZGUgQ2xpZW50ZSAoQ1U3KVxuXG4gICAgb3B0IGRlY2lkZSBjYW5jZWxhciByZXNlcnZhXG4gICAgICAgIENyZWFkb3JSZXNlcnZhIC0-PiBTR0g6IGNhbmNlbGFyUmVzZXJ2YShpZF9yZXNlcnZhKVxuICAgICAgICBOb3RlIG92ZXIgU0dILFNpc3RlbWFEZU1lbnNhamVyw61hOiBDb25maXJtYXIgUmVzZXJ2YSAoQ1UxMClcbiAgICBlbmRcbiIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)

```
sequenceDiagram 
    participant CreadorReserva
    participant SGH
    participant SistemaDeMensajería
    Note over CreadorReserva,SGH: Identificar Cliente (CU8|CU9)
    Note over CreadorReserva,SGH: Identificar Reserva de Cliente (CU7)

    opt decide cancelar reserva
        CreadorReserva ->> SGH: cancelarReserva(id_reserva)
        Note over SGH,SistemaDeMensajería: Confirmar Reserva (CU10)
    end
```

## (E) Máquina de Estados (para revisar) 

Construir, para el caso de uso Hacer Reserva (CU1), una máquina de estados que represente el estado del sistema en la interacción con los actores.

![Tarea 1.2 - Máquina de estados E)](https://mermaid.ink/svg/eyJjb2RlIjoic3RhdGVEaWFncmFtXG4gICAgc3RhdGUgXCJJZGVudGlmaWNhY2nDs24gQ2xpZW50ZVwiIGFzIHMxXG4gICAgc3RhdGUgXCJFbiBjcmVhY2nDs25cIiBhcyBzMlxuICAgIHN0YXRlIFwiQ3JlYWRhXCIgYXMgczNcbiAgICBzdGF0ZSBcIlJlZ2lzdHJhZGFcIiBhcyBzNFxuICAgIHN0YXRlIFwiQ29uZmlybWFkYVwiIGFzIHM1XG4gICAgc3RhdGUgXCJNb2RpZmljYWRhXCIgYXMgczZcbiAgICBzdGF0ZSBcIlNpbiBkaXNwb25pYmlsaWRhZFwiIGFzIHM3XG4gICAgc3RhdGUgXCJBbHRhIENsaWVudGVcIiBhcyBzOFxuXG4gWypdIC0tPiBzMVxuXG4gczEgLS0-IHMyIDogRXhpc3RlIENsaWVudGVcblxuIHMxIC0tPiBzNyA6IE5vIGV4aXN0ZSBkaXNwb25pYmlsaWRhZCBwYXJhIHJlc2VydmFzXG5cbiBzNyAtLT4gczIgOiBTZSByZXZpc2EgZGlzcG9uaWJpbGlkYWQgZW4gb3Ryb3MgaG90ZWxlc1xuXG4gczcgLS0-IFsqXSA6IE5vIGhheSBkaXNwb25pYmlsaWRhZCAobmkgc2lxdWllcmEgZW4gb3Ryb3MgaG90ZWxlcylcblxuIHM3IC0tPiBzNiA6IENsaWVudGUgaW5kaWNhIGRhdG9zIHkgaG90ZWwgZGUgY29udmVuaWVuY2lhXG5cbnM2IC0tPiBzMiA6IFNlIGNhbWJpYW4gZGF0b3MgZGUgcmVzZXJ2YVxuXG4gczEgLS0-IHM4IDogTm8gZXhpc3RlIGNsaWVudGVcblxuIHM4IC0tPiBzMiA6IEV4aXN0ZSBjbGllbnRlXG5cbiBzMiAtLT4gczMgOiBTZSBpbmRpY2FuIGRhdG9zIHBhcmEgcmVzZXJ2YVxuXG4gczMgLS0-IHM0IDogU2UgY29uZmlybWEgZGlzcG9uaWJpbGlkYWQgZGUgaGFiaXRhY2nDs25cblxuIHM0IC0tPiBzNSA6IHNlIGNvbmZpcm1hIHJlc2VydmFcblxuIHM1IC0tPiBbKl1cbiIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)

```
stateDiagram
 state "Identificación Cliente" as s1
 state "En creación" as s2
 state "Creada" as s3
 state "Registrada" as s4
 state "Confirmada" as s5
 state "Modificada" as s6
 state "Sin disponibilidad" as s7
 state "Alta Cliente" as s8
 
 [*] --> s1
 s1 --> s2 : Existe Cliente
 s1 --> s7 : No existe disponibilidad para reservas
 s7 --> s2 : Se revisa disponibilidad en otros hoteles
 s7 --> [*] : No hay disponibilidad (ni siquiera en otros hoteles)
 s7 --> s6 : Cliente indica datos y hotel de conveniencia
 s6 --> s2 : Se cambian datos de reserva
 s1 --> s8 : No existe cliente
 s8 --> s2 : Existe cliente
 s2 --> s3 : Se indican datos para reserva
 s3 --> s4 : Se confirma disponibilidad de habitación
 s4 --> s5 : se confirma reserva
 s5 --> [*]
 ```
 
## Anexo

### Identificar Reserva de Cliente (CU7)

![IdentificarClienteRecepcion](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU0dIXG5cbiAgICBDcmVhZG9yUmVzZXJ2YSAtPj4gU0dIOiByZXNlcnZhcyA9IG9idGVuZXJSZXNlcnZhc0NsaWVudGUoaWRfY2xpZW50ZSwgW05PX1RPTUFEQV0pOiBMaXN0PFJlc2VydmE-XG4gICAgXG4gICAgb3B0IGV4aXN0ZW4gcmVzZXJ2YXNcbiAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogcmVzZXJ2YSA9IG9idGVuZXJSZXNlcnZhKGlkX3Jlc2VydmEpOiBSZXNlcnZhXG4gICAgZW5kXG4iLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

```
sequenceDiagram 
    participant CreadorReserva
    participant SGH

    CreadorReserva ->> SGH: reservas = obtenerReservasCliente(id_cliente, [NO_TOMADA]): List<Reserva>
    
    opt existen reservas
        CreadorReserva ->> SGH: reserva = obtenerReserva(id_reserva): Reserva
    end
```


### Identificar Cliente en Recepción (CU8)

![IdentificarClienteRecepcion](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIFxuICAgIHBhcnRpY2lwYW50IFJlY2VwY2lvbmlzdGFcbiAgICBwYXJ0aWNpcGFudCBTR0hcblxuICAgICAgICBSZWNlcGNpb25pc3RhIC0-PisgU0dIOiBjbGllbnRlczo9IGJ1c2NhckNsaWVudGUobm9tYnJlQ2xpZW50ZTogc3RyaW5nKVxuICAgICAgICBSZWNlcGNpb25pc3RhIC0-PisgU0dIOiBjbGllbnRlOj0gc2VsZWNjaW9uYXJDbGllbnRlKGlkOiBzdHJpbmcpXG4gICAgXG4iLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

```
sequenceDiagram 
    participant Recepcionista
    participant SGH
        Recepcionista ->>+ SGH: clientes:= buscarCliente(nombreCliente: string)
        Recepcionista ->>+ SGH: cliente:= seleccionarCliente(id: string)
```

### Log-In Cliente (CU9)

![LoginCliente](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIFxuICAgIHBhcnRpY2lwYW50IENsaWVudGVcbiAgICBwYXJ0aWNpcGFudCBTR0hcbiAgICBwYXJ0aWNpcGFudCBTaXN0ZW1hRGVNZW5zYWplcmlhXG5cbiAgICAgICAgb3B0IENsaWVudGUgbm8gY29ub2NlIGVsIHBhc3N3b3JkXG4gICAgICAgIENsaWVudGUgLT4-IFNHSDogcmVjdXBlcmFyUGFzc3dvcmQodXN1YXJpbzogc3RyaW5nKVxuICAgICAgICBTR0ggLT4-IFNpc3RlbWFEZU1lbnNhamVyaWE6IGVudmlhclBhc3N3b3JkKHVzdWFyaW86IHN0cmluZylcbiAgICAgICAgZW5kXG4gICAgICAgIENsaWVudGUgLT4-IFNHSDogdmFsaWRvOj0gYXV0ZW50aWNhckNsaWVudGUodXN1YXJpbzogc3RyaW5nLCBwYXNzd29yZDogc3RyaW5nKTogYm9vbGVhblxuICAgICAgICBvcHQgQ3JlZGVuY2lhbGVzIGNvcnJlY3Rhc1xuICAgICAgICBDbGllbnRlIC0-PiBTR0g6IGNsaWVudGU6PSBvYnRlbmVyQ2xpZW50ZShpZF9jbGllbnRlOiBpbnQpXG4gICAgICAgIGVuZFxuICAgIFxuIiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

```
sequenceDiagram 
    
    participant Cliente
    participant SGH
    participant SistemaDeMensajeria

        opt Cliente no conoce el password
        Cliente ->> SGH: recuperarPassword(usuario: string)
        SGH ->> SistemaDeMensajeria: enviarPassword(usuario: string)
        end
        Cliente ->> SGH: valido:= autenticarCliente(usuario: string, password: string): boolean
        opt Credenciales correctas
        Cliente ->> SGH: cliente:= obtenerCliente(id_cliente: int)
        end
```

### Confirmar Reserva (CU10)

![ConfirmarReserva](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIFxuICAgIHBhcnRpY2lwYW50IFNHSFxuICAgIHBhcnRpY2lwYW50IFNpc3RlbWFEZU1lbnNhamVyaWFcblxuICAgICAgICBTR0ggLT4-IFNHSDogbWVuc2FqZSA6PSBwcmVwYXJhck1lbnNhamUoKTogc3RyaW5nXG4gICAgICAgIFNHSCAtPj4gU2lzdGVtYURlTWVuc2FqZXJpYTogZW52aWFyTWVuc2FqZUNsaWVudGUobWVuc2FqZTogc3RyaW5nLCBtZWNhbmlzbW86IE1lY2FuaXNtb0NvbXVuaWNhY2lvbilcblxuXG4iLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

```
sequenceDiagram 

    participant SGH
    participant SistemaDeMensajeria

        SGH ->> SGH: mensaje := prepararMensaje(): string
        SGH ->> SistemaDeMensajeria: enviarMensajeCliente(mensaje: string, mecanismo: MecanismoComunicacion)
```
