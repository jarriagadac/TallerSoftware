![Modelo de Dominio](https://mermaid.ink/svg/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgSG90ZWwge1xuICAgICAgICBpbnQgaWRcbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgICAgICBTdHJpbmcgcGFpc1xuICAgIH1cbiAgICBjbGFzcyBUaXBvSGFiaXRhY2lvbiB7XG4gICAgICAgIGludCBpZFxuICAgICAgICBTdHJpbmcgbm9tYnJlXG4gICAgICAgIGRvdWJsZSB0YXJpZmFcbiAgICAgICAgaW50IGNhcGFjaWRhZFxuICAgIH1cbiAgICBjbGFzcyBIYWJpdGFjaW9uIHtcbiAgICAgICAgaW50IGlkXG4gICAgICAgIFN0cmluZyBub21icmVcbiAgICB9XG4gICAgY2xhc3MgVXN1YXJpbyB7XG4gICAgICAgIFN0cmluZyB1c3VhcmlvXG4gICAgICAgIFN0cmluZyBwYXNzd29yZFxuICAgIH1cbiAgICBjbGFzcyBDbGllbnRlIHtcbiAgICAgICAgaW50IGlkXG4gICAgICAgIFN0cmluZyBkb2N1bWVudG9cbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgICAgICBTdHJpbmcgbWFpbFxuICAgICAgICBTdHJpbmcgYmVlcGVyXG4gICAgICAgIFN0cmluZyBjZWx1bGFyXG4gICAgICAgIFN0cmluZyBmYXhcbiAgICAgICAgaW50IG1vZG9fY29tdW5pY2FjaW9uXG4gICAgfVxuICAgIGNsYXNzIEh1ZXNwZWQge1xuICAgICAgICBpbnQgaWRcbiAgICAgICAgU3RyaW5nIGRvY3VtZW50b1xuICAgICAgICBTdHJpbmcgbm9tYnJlXG4gICAgfVxuICAgIGNsYXNzIFJlY2VwY2lvbmlzdGFcbiAgICBjbGFzcyBFc3RhZG9SZXNlcnZhIHtcbiAgICAgICAgTm8gVG9tYWRhXG4gICAgICAgIFRvbWFkYVxuICAgICAgICBUZXJtaW5hZGFcbiAgICAgICAgQ2FuY2VsYWRhXG4gICAgfVxuICAgIDw8ZW51bWVyYXRpb24-PiBFc3RhZG9SZXNlcnZhXG4gXG4gICAgY2xhc3MgUmVzZXJ2YSB7XG4gICAgICAgIGludCBpZFxuICAgICAgICBTdHJpbmcgY29kaWdvXG4gICAgICAgIERhdGUgZmVjaGFfaW5pY2lvXG4gICAgICAgIERhdGUgZmVjaGFfdGVybWlub1xuICAgICAgICBFc3RhZG9SZXNlcnZhIGVzdGFkb1xuICAgICAgICBib29sIG1vZGlmaWNhYmxlXG4gICAgfVxuIFxuICAgIFJlc2VydmEgXCIqXCIgby0tIFwiMVwiIEhvdGVsXG4gICAgUmVzZXJ2YSBcIipcIiBvLS0gXCIxXCIgQ2xpZW50ZVxuICAgIFJlc2VydmEgXCIqXCIgby0tIFwiMVwiIFRpcG9IYWJpdGFjaW9uXG4gICAgUmVzZXJ2YSBcIipcIiBvLS0gXCIwLi4xXCIgSGFiaXRhY2lvblxuICAgIFJlc2VydmEgXCIxXCIgKi0tIFwiKlwiIEh1ZXNwZWRcbiBcbiAgICBIYWJpdGFjaW9uIFwiKlwiIG8tLSBcIjFcIiBUaXBvSGFiaXRhY2lvblxuICAgIEhhYml0YWNpb24gXCIxXCIgLS0qIFwiKlwiIEhvdGVsXG4gXG4gICAgQ2xpZW50ZSAtLXw-IFVzdWFyaW86IFxuICAgIEh1ZXNwZWQgLS18PiBVc3VhcmlvOiBcbiAgICBSZWNlcGNpb25pc3RhIC0tfD4gVXN1YXJpbzogXG4gXG4gICAgQWRtaW5pc3RyYWRvclJlc2VydmEgLi4-IFJlc2VydmE6IGNhZHVjYSIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)

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
