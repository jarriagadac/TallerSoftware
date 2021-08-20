# Tarea 1.2

## (A) Hacer Reservas

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Hacer Reserva (CU1). Para ello considerar solamente los casos de uso incluidos Identificar Cliente en Recepción (CU8) y Alta Cliente.

![HacerReservas](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlTWVuc2FqZXLDrWFcblxuICAgICUlIDFcbiAgICBhbHQgY2xpZW50ZSBubyByZWdpc3RyYWRvXG4gICAgICAgIE5vdGUgb3ZlciBDcmVhZG9yUmVzZXJ2YSxTR0g6IEFsdGEgZGUgQ2xpZW50ZVxuICAgIGVsc2UgY2xpZW50ZSByZWdpc3RyYWRvXG4gICAgICAgIE5vdGUgb3ZlciBDcmVhZG9yUmVzZXJ2YSxTR0g6IEluY2x1aXIgSWRlbnRpZmljYXIgQ2xpZW50ZSAoQ1U4fENVOSlcbiAgICBlbmRcblxuICAgICUlIDIgeSAzXG4gICAgbG9vcFxuICAgICAgICBDcmVhZG9yUmVzZXJ2YSAtPj4gU0dIOiBkaXNwb25pYmlsaWRhZCA9IGNvbmZpcm1hckRpc3BvbmliaWxpZGFkKGlkX2hvdGVsOiBpbnQsIGlkX3RpcG9faGFiaXRhY2lvbjogaW50LCBmaW5pY2lvOiBkYXRlLCBmZmluOiBkYXRlKSA6IEJvb2xcbiAgICAgICAgb3B0IG5vIGhheSBkaXNwb25pYmlsaWRhZFxuICAgICAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogYWx0ZXJuYXRpdmFzID0gYnVzY2FyQWx0ZXJuYXRpdmFzKHBhaXM6IHN0ciwgaWRfdGlwb19oYWJpdGFjaW9uOiBpbnQsIGZpbmljaW86IGRhdGUsIGZmaW46IGRhdGUpIDogTGlzdDxIb3RlbD5cbiAgICAgICAgZW5kXG4gICAgZW5kXG4gICAgXG4gICAgJSU0XG4gICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogcmVnaXN0cmFyUmVzZXJ2YShpZF9ob3RlbDogaW50LCBpZF90aXBvX2hhYml0YWNpb246IGludCwgZmluaWNpbzogZGF0ZSwgZmZpbjogZGF0ZSwgbW9kaWZpY2FibGU6IGJvb2wpXG5cbiAgICBOb3RlIG92ZXIgU0dILFNpc3RlbWFEZU1lbnNhamVyw61hOiBJbmNsdWlyIENvbmZpcm1hciBSZXNlcnZhIChDVTEwKSIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)

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
        CreadorReserva ->> SGH: disponibilidad = confirmarDisponibilidad(id_hotel: int, id_tipo_habitacion: int, finicio: date, ffin: date) : Bool
        opt no hay disponibilidad
            CreadorReserva ->> SGH: alternativas = buscarAlternativas(pais: str, id_tipo_habitacion: int, finicio: date, ffin: date) : List<Hotel>
        end
    end
    
    %%4
    CreadorReserva ->> SGH: registrarReserva(id_hotel: int, id_tipo_habitacion: int, finicio: date, ffin: date, modificable: bool)

    Note over SGH,SistemaDeMensajería: Incluir Confirmar Reserva (CU10)
```

## (B) Modificar Reserva

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Modificar Reserva (CU2).

![ModificarReserva](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlTWVuc2FqZXLDrWFcbiAgICBOb3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU0dIOiBJZGVudGlmaWNhciBDbGllbnRlIChDVTh8Q1U5KVxuICAgIE5vdGUgb3ZlciBDcmVhZG9yUmVzZXJ2YSxTR0g6IElkZW50aWZpY2FyIFJlc2VydmEgZGUgQ2xpZW50ZSAoQ1U3KVxuXG4gICAgJSUgM1xuICAgIGxvb3AgbW9kaWZpY2FyIHJlc2VydmFcbiAgICAgICAgbG9vcCBlbmNvbnRyYXIgaG90ZWwgZGlzcG9uaWJsZVxuICAgICAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogZGlzcG9uaWJpbGlkYWQgPSBjb25maXJtYXJEaXNwb25pYmlsaWRhZChpZF9ob3RlbDogaW50LCBpZF90aXBvX2hhYml0YWNpb246IGludCwgZmluaWNpbzogZGF0ZSwgZmZpbjogZGF0ZSkgOiBCb29sXG4gICAgICAgICAgICBvcHQgbm8gaGF5IGRpc3BvbmliaWxpZGFkXG4gICAgICAgICAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogYWx0ZXJuYXRpdmFzID0gYnVzY2FyQWx0ZXJuYXRpdmFzKHBhaXM6IHN0ciwgaWRfdGlwb19oYWJpdGFjaW9uOiBpbnQsIGZpbmljaW86IGRhdGUsIGZmaW46IGRhdGUpIDogTGlzdDxIb3RlbD5cbiAgICAgICAgICAgIGVuZFxuICAgICAgICBlbmRcblxuICAgICAgICBvcHQgY29uZmlybWEgbW9kaWZpY2FjaW9uXG4gICAgICAgICAgICBDcmVhZG9yUmVzZXJ2YSAtPj4gU0dIOiBtb2RpZmljYXJSZXNlcnZhKGlkX2hvdGVsOiBpbnQsIGlkX3RpcG9faGFiaXRhY2lvbjogaW50LCBmaW5pY2lvOiBkYXRlLCBmZmluOiBkYXRlLCBtb2RpZmljYWJsZTogYm9vbClcbiAgICAgICAgICAgIE5vdGUgb3ZlciBTR0gsU2lzdGVtYURlTWVuc2FqZXLDrWE6IENvbmZpcm1hciBSZXNlcnZhIChDVTEwKVxuICAgICAgICBlbmRcbiAgICBlbmQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

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
            CreadorReserva ->> SGH: disponibilidad = confirmarDisponibilidad(id_hotel: int, id_tipo_habitacion: int, finicio: date, ffin: date) : Bool
            opt no hay disponibilidad
                CreadorReserva ->> SGH: alternativas = buscarAlternativas(pais: str, id_tipo_habitacion: int, finicio: date, ffin: date) : List<Hotel>
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

![TomarReserva](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IFJlY2VwY2lvbmlzdGFcbiAgICBwYXJ0aWNpcGFudCBTR0hcbiAgICBwYXJ0aWNpcGFudCBTaXN0ZW1hTWVuc2FqZXJpYVxuICAgIHBhcnRpY2lwYW50IFNpc3RlbWFEZUZhY3R1cmFjacOzblxuICAgIFxuICAgIFJlY2VwY2lvbmlzdGEgLT4-IFNHSDogcmVzZXJ2YXMgPSBvYnRlbmVyUmVzZXJ2YXMoTk9fVE9NQURBKVxuICAgIFxuICAgIG9wdCBubyBoYXkgcmVzZXJ2YXMgbyBubyBoYXkgdW5hIHJlc2VydmEgcGFyYSBlbCBjbGllbnRlXG4gICAgICAgIE5vdGUgb3ZlciBSZWNlcGNpb25pc3RhLCBTaXN0ZW1hTWVuc2FqZXJpYTogSW5jbHVpciBIYWNlciBSZXNlcnZhIChDVTEpXG4gICAgZW5kXG5cbiAgICBSZWNlcGNpb25pc3RhIC0-PiBTR0g6IHJlc2VydmEgPSBvYnRlbmVyUmVzZXJ2YShpZF9yZXNlcnZhOiBpbnQpOiBSZXNlcnZhXG5cbiAgICBvcHQgbW9kaWZpY2FyIGRhdG9zIGRlIGxhIHJlc2VydmEgeSByZXNlcnZhIG1vZGlmaWNhYmxlXG4gICAgICAgIE5vdGUgb3ZlciBSZWNlcGNpb25pc3RhLCBTaXN0ZW1hTWVuc2FqZXJpYTogSW5jbHVpciBNb2RpZmljYXIgUmVzZXJ2YSAoQ1UyKVxuICAgIGVuZFxuXG4gICAgb3B0IGFzaWduYXIgaGFiaXRhY2nDs24gYWwgaHVlc3BlZFxuICAgICAgICBSZWNlcGNpb25pc3RhIC0-PiBTR0g6IGhhYml0YWNpb24gPSBhc2lnbmFySGFiaXRhY2lvbihpZF9yZXNlcnZhOiBpbnQpOiBIYWJpdGFjaW9uXG4gICAgICAgIFNHSCAtPj4gU2lzdGVtYURlRmFjdHVyYWNpw7NuOiBub3RpZmljYXJJbmljaW9Fc3RhZGlhKGlkX3Jlc2VydmE6IGludClcbiAgICBlbmQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

```
sequenceDiagram 
    participant Recepcionista
    participant SGH
    participant SistemaMensajeria
    participant SistemaDeFacturación
    
    Recepcionista ->> SGH: reservas = obtenerReservas(NO_TOMADA)
    
    opt no hay reservas o no hay una reserva para el cliente
        Note over Recepcionista, SistemaMensajeria: Incluir Hacer Reserva (CU1)
    end

    Recepcionista ->> SGH: reserva = obtenerReserva(id_reserva: int): Reserva

    opt modificar datos de la reserva y reserva modificable
        Note over Recepcionista, SistemaMensajeria: Incluir Modificar Reserva (CU2)
    end

    opt asignar habitación al huesped
        Recepcionista ->> SGH: habitacion = asignarHabitacion(id_reserva: int): Habitacion
        SGH ->> SistemaDeFacturación: notificarInicioEstadia(id_reserva: int)
    end
```

## (D) Cancelar Reserva (para revisar) 

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

![Tarea 1.2 - Diagrama de secuencia D)](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENsaWVudGVcbiAgICBwYXJ0aWNpcGFudCBSZWNlcGNpb25pc3RhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlRmFjdHVyYWNpw7NuXG4gIFxuICAgIENsaWVudGUgLT4-KyBSZWNlcGNpb25pc3RhOiBFbnRyZWdhckRhdG9zUmVzZXJ2YShjb2RpZ28sIG5vbWJyZV9jbGllbnRlLCBmZWNoYV9jaGVja19pbiwgZmVjaGFfY2hlY2tfb3V0KVxuICAgIFJlY2VwY2lvbmlzdGEgLT4-LSBTR0g6IENvbnN1bHRhclJlc2VydmFQb3JJRChjb2RpZ28pXG4gICAgYWN0aXZhdGUgU0dIXG4gICAgYWx0IE5vIHNlIHRpZW5lIHJlc2VydmEgcmVnaXN0cmFkYVxuICAgICAgICBTR0ggLS0-KyBSZWNlcGNpb25pc3RhOiBEZXZvbHZlclJlc2VydmFOb0VuY29udHJhZGEobWVuc2FqZSlcbiAgICAgICAgZGVhY3RpdmF0ZSBTR0hcbiAgICAgICAgUmVjZXBjaW9uaXN0YSAtLT4tQ2xpZW50ZTogRGV2b2x2ZXJSZXNlcnZhTm9FbmNvbnRyYWRhKG1lbnNhamUpICAgICAgIFxuICAgIGVsc2UgU2UgdGllbmUgcmVzZXJ2YSByZWdpc3RyYWRhXG4gICAgICAgIFNHSCAtLT4rIFJlY2VwY2lvbmlzdGE6IERldm9sdmVyRGF0b3NSZXNlcnZhKClcbiAgICBlbmRcbiAgICBSZWNlcGNpb25pc3RhIC0-PisgU0dIOiBBbnVsYXJSZXNlcnZhKGNvZGlnbylcbiAgICBhbHQgTm8gc2UgaGEgbGxlZ2FkbyBhIGZlY2hhIGRlIHNlciB0b21hZGFcbiAgICAgICAgU0dIIC0tPiBSZWNlcGNpb25pc3RhOiBEZXZvbHZlckVzdGFkb1Jlc2VydmEobWVuc2FqZSlcbiAgICBlbHNlIFNlIGxsZWfDsyBhIGxhIGZlY2hhIGRlIHNlciB0b21hZGFcbiAgICAgICAgU0dIIC0-Pi0gU2lzdGVtYURlRmFjdHVyYWNpw7NuOiBTb2xpY2l0YXJSZWVtYm9sc28oY29kaWdvLCBkaWFzX3Jlc3RhbnRlcylcbiAgICAgICAgYWN0aXZhdGUgU2lzdGVtYURlRmFjdHVyYWNpw7NuXG4gICAgICAgIFNpc3RlbWFEZUZhY3R1cmFjacOzbiAtLT4rIFNHSDogRW50cmVnYVJlZW1ib2xzbyhjb2RpZ28sIGNvZGlnb19vcGVyYWNpb24sIGN1ZW50YSwgbW9udG8pXG4gICAgICAgIGRlYWN0aXZhdGUgU2lzdGVtYURlRmFjdHVyYWNpw7NuXG4gICAgICAgIFNHSCAtPj4gU0dIOiBQcm9jZXNhckFudWxhY2lvbihjb2RpZ28sIGN1ZW50YSwgbW9udG8pXG4gICAgICAgIFNHSCAtLT4tIFJlY2VwY2lvbmlzdGE6IERldm9sdmVyRXN0YWRvUmVzZXJ2YShtZW5zYWplKVxuICAgIGVuZFxuXG5cbiIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)

```
sequenceDiagram 
    participant Cliente
    participant Recepcionista
    participant SGH
    participant SistemaDeFacturación
  
    Cliente ->>+ Recepcionista: EntregarDatosReserva(codigo, nombre_cliente, fecha_check_in, fecha_check_out)
    Recepcionista ->>- SGH: ConsultarReservaPorID(codigo)
    activate SGH
    alt No se tiene reserva registrada
        SGH -->+ Recepcionista: DevolverReservaNoEncontrada(mensaje)
        deactivate SGH
        Recepcionista -->-Cliente: DevolverReservaNoEncontrada(mensaje)       
    else Se tiene reserva registrada
        SGH -->+ Recepcionista: DevolverDatosReserva()
    end
    Recepcionista ->>+ SGH: AnularReserva(codigo)
    alt No se ha llegado a fecha de ser tomada
        SGH --> Recepcionista: DevolverEstadoReserva(mensaje)
    else Se llegó a la fecha de ser tomada
        SGH ->>- SistemaDeFacturación: SolicitarReembolso(codigo, dias_restantes)
        activate SistemaDeFacturación
        SistemaDeFacturación -->+ SGH: EntregaReembolso(codigo, codigo_operacion, cuenta, monto)
        deactivate SistemaDeFacturación
        SGH ->> SGH: ProcesarAnulacion(codigo, cuenta, monto)
        SGH -->- Recepcionista: DevolverEstadoReserva(mensaje)
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
