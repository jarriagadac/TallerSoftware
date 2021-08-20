![Modelo de Dominio](https://mermaid.ink/svg/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgSG90ZWwge1xuICAgICAgICBpbnQgaWRcbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgICAgICBTdHJpbmcgcGFpc1xuICAgIH1cbiAgICBjbGFzcyBUaXBvSGFiaXRhY2lvbiB7XG4gICAgICAgIGludCBpZFxuICAgICAgICBTdHJpbmcgbm9tYnJlXG4gICAgICAgIGRvdWJsZSB0YXJpZmFcbiAgICAgICAgaW50IGNhcGFjaWRhZFxuICAgIH1cbiAgICBjbGFzcyBIYWJpdGFjaW9uIHtcbiAgICAgICAgaW50IGlkXG4gICAgICAgIFN0cmluZyBub21icmVcbiAgICB9XG4gICAgY2xhc3MgVXN1YXJpbyB7XG4gICAgICAgIFN0cmluZyB1c3VhcmlvXG4gICAgICAgIFN0cmluZyBwYXNzd29yZFxuICAgIH1cbiAgICBjbGFzcyBDbGllbnRlIHtcbiAgICAgICAgaW50IGlkXG4gICAgICAgIFN0cmluZyBwYWlzXG4gICAgICAgIFN0cmluZyBkb2N1bWVudG9cbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgICAgICBTdHJpbmcgbWFpbFxuICAgICAgICBTdHJpbmcgYmVlcGVyXG4gICAgICAgIFN0cmluZyBjZWx1bGFyXG4gICAgICAgIFN0cmluZyBmYXhcbiAgICAgICAgTWVjYW5pc21vQ29tdW5pY2FjaW9uIG1jXG4gICAgfVxuICAgIGNsYXNzIE1lY2FuaXNtb0NvbXVuaWNhY2lvbiB7XG4gICAgICAgIGVtYWlsXG4gICAgICAgIGZheFxuICAgICAgICBjZWx1bGFyXG4gICAgICAgIGJlZXBlclxuICAgIH1cbiAgICA8PGVudW1lcmF0aW9uPj4gTWVjYW5pc21vQ29tdW5pY2FjaW9uXG5cbiAgICBjbGFzcyBIdWVzcGVkIHtcbiAgICAgICAgaW50IGlkXG4gICAgICAgIFN0cmluZyBkb2N1bWVudG9cbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgIH1cbiAgICBjbGFzcyBSZWNlcGNpb25pc3RhXG4gICAgY2xhc3MgRXN0YWRvUmVzZXJ2YSB7XG4gICAgICAgIE5vIFRvbWFkYVxuICAgICAgICBUb21hZGFcbiAgICAgICAgVGVybWluYWRhXG4gICAgICAgIENhbmNlbGFkYVxuICAgIH1cbiAgICA8PGVudW1lcmF0aW9uPj4gRXN0YWRvUmVzZXJ2YVxuIFxuICAgIGNsYXNzIFJlc2VydmEge1xuICAgICAgICBpbnQgaWRcbiAgICAgICAgU3RyaW5nIGNvZGlnb1xuICAgICAgICBEYXRlIGZlY2hhX2luaWNpb1xuICAgICAgICBEYXRlIGZlY2hhX3Rlcm1pbm9cbiAgICAgICAgRXN0YWRvUmVzZXJ2YSBlc3RhZG9cbiAgICAgICAgYm9vbCBtb2RpZmljYWJsZVxuICAgIH1cbiBcbiAgICBSZXNlcnZhIFwiKlwiIG8tLSBcIjFcIiBIb3RlbFxuICAgIFJlc2VydmEgXCIqXCIgby0tIFwiMVwiIENsaWVudGVcbiAgICBSZXNlcnZhIFwiKlwiIG8tLSBcIjFcIiBUaXBvSGFiaXRhY2lvblxuICAgIFJlc2VydmEgXCIqXCIgby0tIFwiMC4uMVwiIEhhYml0YWNpb25cbiAgICBSZXNlcnZhIFwiMVwiICotLSBcIipcIiBIdWVzcGVkXG4gXG4gICAgSGFiaXRhY2lvbiBcIipcIiBvLS0gXCIxXCIgVGlwb0hhYml0YWNpb25cbiAgICBIYWJpdGFjaW9uIFwiMVwiIC0tKiBcIipcIiBIb3RlbFxuIFxuICAgIENsaWVudGUgLS18PiBVc3VhcmlvOiBcbiAgICBIdWVzcGVkIC0tfD4gVXN1YXJpbzogXG4gICAgUmVjZXBjaW9uaXN0YSAtLXw-IFVzdWFyaW86IFxuIFxuICAgIEFkbWluaXN0cmFkb3JSZXNlcnZhIC4uPiBSZXNlcnZhOiBjYWR1Y2EiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

https://mermaid-js.github.io/mermaid-live-editor

```
classDiagram
    class Hotel {
        int id
        String nombre
        String pais
    }
    class TipoHabitacion {
        int id
        String nombre
        double tarifa
        int capacidad
    }
    class Habitacion {
        int id
        String nombre
    }
    class Usuario {
        String usuario
        String password
    }
    class Cliente {
        int id
        String pais
        String documento
        String nombre
        String mail
        String beeper
        String celular
        String fax
        MecanismoComunicacion mc
    }
    class MecanismoComunicacion {
        email
        fax
        celular
        beeper
    }
    <<enumeration>> MecanismoComunicacion

    class Huesped {
        int id
        String documento
        String nombre
    }
    class Recepcionista
    class EstadoReserva {
        No Tomada
        Tomada
        Terminada
        Cancelada
    }
    <<enumeration>> EstadoReserva
 
    class Reserva {
        int id
        String codigo
        Date fecha_inicio
        Date fecha_termino
        EstadoReserva estado
        bool modificable
    }
 
    Reserva "*" o-- "1" Hotel
    Reserva "*" o-- "1" Cliente
    Reserva "*" o-- "1" TipoHabitacion
    Reserva "*" o-- "0..1" Habitacion
    Reserva "1" *-- "*" Huesped
 
    Habitacion "*" o-- "1" TipoHabitacion
    Habitacion "1" --* "*" Hotel
 
    Cliente --|> Usuario: 
    Huesped --|> Usuario: 
    Recepcionista --|> Usuario: 
 
    AdministradorReserva ..> Reserva: caduca
```
