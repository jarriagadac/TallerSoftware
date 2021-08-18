![Modelo de Dominio](https://mermaid.ink/svg/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG4gICAgY2xhc3MgSG90ZWwge1xuICAgICAgICBTdHJpbmcgbm9tYnJlXG4gICAgICAgIFN0cmluZyBwYWlzXG4gICAgfVxuICAgIGNsYXNzIFRpcG9IYWJpdGFjaW9uIHtcbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgICAgICBkb3VibGUgdGFyaWZhXG4gICAgICAgIGludCBjYXBhY2lkYWRcbiAgICB9XG4gICAgY2xhc3MgSGFiaXRhY2lvbiB7XG4gICAgICAgIFN0cmluZyBub21icmVcbiAgICB9XG4gICAgY2xhc3MgVXN1YXJpbyB7XG4gICAgICAgIFN0cmluZyB1c3VhcmlvXG4gICAgICAgIFN0cmluZyBwYXNzd29yZFxuICAgIH1cbiAgICBjbGFzcyBDbGllbnRlIHtcbiAgICAgICAgU3RyaW5nIGlkZW50aWZpY2Fkb3JcbiAgICAgICAgU3RyaW5nIG5vbWJyZVxuICAgICAgICBTdHJpbmcgbWFpbFxuICAgICAgICBTdHJpbmcgYmVlcGVyXG4gICAgICAgIFN0cmluZyBjZWx1bGFyXG4gICAgICAgIFN0cmluZyBmYXhcbiAgICAgICAgaW50IG1vZG9fY29tdW5pY2FjaW9uXG4gICAgfVxuICAgIGNsYXNzIEh1ZXNwZWQge1xuICAgICAgICBTdHJpbmcgaWRlbnRpZmljYWRvclxuICAgICAgICBTdHJpbmcgbm9tYnJlXG4gICAgfVxuICAgIGNsYXNzIFJlY2VwY2lvbmlzdGFcbiBcbiAgICBjbGFzcyBSZXNlcnZhIHtcbiAgICAgICAgU3RyaW5nIGNvZGlnb1xuICAgICAgICBEYXRlIGZlY2hhX2luaWNpb1xuICAgICAgICBEYXRlIGZlY2hhX3Rlcm1pbm9cbiAgICAgICAgYm9vbCBlc3RhZG9cbiAgICB9XG4gXG4gICAgUmVzZXJ2YSBcIipcIiBvLS0gXCIxXCIgSG90ZWxcbiAgICBSZXNlcnZhIFwiKlwiIG8tLSBcIjFcIiBDbGllbnRlXG4gICAgUmVzZXJ2YSBcIipcIiBvLS0gXCIxXCIgVGlwb0hhYml0YWNpb25cbiAgICBSZXNlcnZhIFwiKlwiIG8tLSBcIjAuLjFcIiBIYWJpdGFjaW9uXG4gICAgUmVzZXJ2YSBcIjFcIiAqLS0gXCIqXCIgSHVlc3BlZFxuIFxuICAgIEhhYml0YWNpb24gXCIqXCIgby0tIFwiMVwiIFRpcG9IYWJpdGFjaW9uXG4gICAgSGFiaXRhY2lvbiBcIjFcIiAtLSogXCIqXCIgSG90ZWxcbiBcbiBcbiAgICBDbGllbnRlIC0tfD4gVXN1YXJpbzogXG4gICAgSHVlc3BlZCAtLXw-IFVzdWFyaW86IFxuICAgIFJlY2VwY2lvbmlzdGEgLS18PiBVc3VhcmlvOiBcbiBcbiAgICBBZG1pbmlzdHJhZG9yUmVzZXJ2YSAuLj4gUmVzZXJ2YTogY2FkdWNhIiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

https://mermaid-js.github.io/mermaid-live-editor

```
classDiagram
    class Hotel {
        String nombre
        String pais
    }
    class TipoHabitacion {
        String nombre
        double tarifa
        int capacidad
    }
    class Habitacion {
        String nombre
    }
    class Usuario {
        String usuario
        String password
    }
    class Cliente {
        String identificador
        String nombre
        String mail
        String beeper
        String celular
        String fax
        int modo_comunicacion
    }
    class Huesped {
        String identificador
        String nombre
    }
    class Recepcionista
 
    class Reserva {
        String codigo
        Date fecha_inicio
        Date fecha_termino
        bool estado
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
