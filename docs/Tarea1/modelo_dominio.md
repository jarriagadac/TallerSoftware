![Modelo de Dominio](https://mermaid.ink/svg/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgSG90ZWwge1xuICAgICAgICBpbnQgaWRcbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgICAgICBTdHJpbmcgcGFpc1xuICAgIH1cbiAgICBjbGFzcyBUaXBvSGFiaXRhY2lvbiB7XG4gICAgICAgIGludCBpZFxuICAgICAgICBTdHJpbmcgbm9tYnJlXG4gICAgICAgIGRvdWJsZSB0YXJpZmFcbiAgICAgICAgaW50IGNhcGFjaWRhZFxuICAgIH1cbiAgICBjbGFzcyBIYWJpdGFjaW9uIHtcbiAgICAgICAgaW50IGlkXG4gICAgICAgIFN0cmluZyBub21icmVcbiAgICB9XG4gICAgY2xhc3MgVXN1YXJpbyB7XG4gICAgICAgIFN0cmluZyB1c3VhcmlvXG4gICAgICAgIFN0cmluZyBwYXNzd29yZFxuICAgIH1cbiAgICBjbGFzcyBDbGllbnRlIHtcbiAgICAgICAgaW50IGlkXG4gICAgICAgIFN0cmluZyBkb2N1bWVudG9cbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgICAgICBTdHJpbmcgbWFpbFxuICAgICAgICBTdHJpbmcgYmVlcGVyXG4gICAgICAgIFN0cmluZyBjZWx1bGFyXG4gICAgICAgIFN0cmluZyBmYXhcbiAgICAgICAgaW50IG1vZG9fY29tdW5pY2FjaW9uXG4gICAgfVxuICAgIGNsYXNzIEh1ZXNwZWQge1xuICAgICAgICBpbnQgaWRcbiAgICAgICAgU3RyaW5nIGRvY3VtZW50b1xuICAgICAgICBTdHJpbmcgbm9tYnJlXG4gICAgfVxuICAgIGNsYXNzIFJlY2VwY2lvbmlzdGFcbiAgICBjbGFzcyBFc3RhZG9SZXNlcnZhIHtcbiAgICAgICAgTm8gVG9tYWRhXG4gICAgICAgIFRvbWFkYVxuICAgICAgICBUZXJtaW5hZGFcbiAgICAgICAgQ2FuY2VsYWRhXG4gICAgICAgIEZpbmFsaXphZGFcbiAgICB9XG4gICAgPDxlbnVtZXJhdGlvbj4-IEVzdGFkb1Jlc2VydmFcbiBcbiAgICBjbGFzcyBSZXNlcnZhIHtcbiAgICAgICAgaW50IGlkXG4gICAgICAgIFN0cmluZyBjb2RpZ29cbiAgICAgICAgRGF0ZSBmZWNoYV9pbmljaW9cbiAgICAgICAgRGF0ZSBmZWNoYV90ZXJtaW5vXG4gICAgICAgIEVzdGFkb1Jlc2VydmEgZXN0YWRvXG4gICAgICAgIGJvb2wgbW9kaWZpY2FibGVcbiAgICB9XG4gXG4gICAgUmVzZXJ2YSBcIipcIiBvLS0gXCIxXCIgSG90ZWxcbiAgICBSZXNlcnZhIFwiKlwiIG8tLSBcIjFcIiBDbGllbnRlXG4gICAgUmVzZXJ2YSBcIipcIiBvLS0gXCIxXCIgVGlwb0hhYml0YWNpb25cbiAgICBSZXNlcnZhIFwiKlwiIG8tLSBcIjAuLjFcIiBIYWJpdGFjaW9uXG4gICAgUmVzZXJ2YSBcIjFcIiAqLS0gXCIqXCIgSHVlc3BlZFxuIFxuICAgIEhhYml0YWNpb24gXCIqXCIgby0tIFwiMVwiIFRpcG9IYWJpdGFjaW9uXG4gICAgSGFiaXRhY2lvbiBcIjFcIiAtLSogXCIqXCIgSG90ZWxcbiBcbiAgICBDbGllbnRlIC0tfD4gVXN1YXJpbzogXG4gICAgSHVlc3BlZCAtLXw-IFVzdWFyaW86IFxuICAgIFJlY2VwY2lvbmlzdGEgLS18PiBVc3VhcmlvOiBcbiBcbiAgICBBZG1pbmlzdHJhZG9yUmVzZXJ2YSAuLj4gUmVzZXJ2YTogY2FkdWNhIiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

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
        String documento
        String nombre
        String mail
        String beeper
        String celular
        String fax
        int modo_comunicacion
    }
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
        Finalizada
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
