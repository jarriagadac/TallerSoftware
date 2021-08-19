# Tarea 1.2

## (A) Hacer Reservas (para revisar)

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Hacer Reserva (CU1). Para ello considerar solamente los casos de uso incluidos Identificar Cliente en Recepción (CU8) y Alta Cliente.

### versión 1

![HacerReservas](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlTWVuc2FqZXLDrWFcblxuICAgICUlIDFcbiAgICBhbHQgY2xpZW50ZSBubyByZWdpc3RyYWRvXG4gICAgICAgIE5vdGUgb3ZlciBDcmVhZG9yUmVzZXJ2YSxTaXN0ZW1hRGVNZW5zYWplcsOtYTogQWx0YSBkZSBDbGllbnRlXG4gICAgZWxzZSBjbGllbnRlIGVuIHJlY2VwY2nDs25cbiAgICAgICAgTm90ZSBvdmVyIENyZWFkb3JSZXNlcnZhLFNpc3RlbWFEZU1lbnNhamVyw61hOiBJbmNsdWlyIENVOFxuICAgIGVsc2UgY2xpZW50ZSBkZSBmb3JtYSByZW1vdGFcbiAgICAgICAgTm90ZSBvdmVyIENyZWFkb3JSZXNlcnZhLFNpc3RlbWFEZU1lbnNhamVyw61hOiBJbmNsdWlyIENVOVxuICAgIGVuZFxuXG4gICAgJSUyIHkgM1xuICAgIGxvb3BcbiAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogZGlzcG9uaWJpbGlkYWQgPSBjb25maXJtYXJEaXNwb25pYmlsaWRhZChob3RlbCwgdGlwb19oYWJpdGFjaW9uLCBmaW5pY2lvLCBmZmluKSA6IEJvb2xcbiAgICAgICAgYWx0IG5vIGhheSBkaXNwb25pYmlsaWRhZFxuICAgICAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogYWx0ZXJuYXRpdmFzID0gYnVzY2FyQWx0ZXJuYXRpdmFzKHBhaXMsIHRpcG9faGFiaXRhY2lvbiwgZmluaWNpbywgZmZpbikgOiBMaXN0PEhvdGVsPlxuICAgICAgICBlbmRcbiAgICBlbmRcbiAgICBcbiAgICAlJTRcbiAgICBDcmVhZG9yUmVzZXJ2YSAtPj4gU0dIOiByZWdpc3RyYXJSZXNlcnZhKGhvdGVsLCB0aXBvX2hhYml0YWNpb24sIGZpbmljaW8sIGZmaW4pXG5cbiAgICBOb3RlIG92ZXIgU0dILFNpc3RlbWFEZU1lbnNhamVyw61hOiBJbmNsdWlyIENVMTBcbiIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)

```
sequenceDiagram 
    participant CreadorReserva
    participant SGH
    participant SistemaDeMensajería

    %% 1
    alt cliente no registrado
        Note over CreadorReserva,SistemaDeMensajería: Alta de Cliente
    else cliente en recepción
        Note over CreadorReserva,SistemaDeMensajería: Incluir CU8
    else cliente de forma remota
        Note over CreadorReserva,SistemaDeMensajería: Incluir CU9
    end

    %%2 y 3
    loop
        CreadorReserva ->> SGH: disponibilidad = confirmarDisponibilidad(hotel, tipo_habitacion, finicio, ffin) : Bool
        alt no hay disponibilidad
            CreadorReserva ->> SGH: alternativas = buscarAlternativas(pais, tipo_habitacion, finicio, ffin) : List<Hotel>
        end
    end
    
    %%4
    CreadorReserva ->> SGH: registrarReserva(hotel, tipo_habitacion, finicio, ffin)

    Note over SGH,SistemaDeMensajería: Incluir CU10
```

## (B) Modificar Reserva (para revisar)

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Modificar Reserva (CU2).

### version 1

![Tarea 1.2 - Diagrama de secuencia B)](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlTWVuc2FqZXLDrWFcbiAgICBOb3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU2lzdGVtYURlTWVuc2FqZXLDrWE6IEluY2x1aXIgQ1U4IHkgQ1U5XG4gICAgTm90ZSBvdmVyIENyZWFkb3JSZXNlcnZhLFNpc3RlbWFEZU1lbnNhamVyw61hOiBJbmNsdWlyIENVN1xuIFxuIFxuICAgIGFsdCBTZSBxdWllcmUgbW9kaWZpY2FyIGxhIHJlc2VydmFcbiAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-KyBTaXN0ZW1hRGVNZW5zYWplcsOtYTogTW9kaWZpY2FyRGF0b3NSZXNlcnZhKGZlY2hhX2luaWNpbywgZmVjaGFfdGVybWlubywgZXN0YWRvKVxuICAgICAgICBTaXN0ZW1hRGVNZW5zYWplcsOtYSAtPj4rIFNpc3RlbWFEZU1lbnNhamVyw61hOiBWZXJpZmljYXJEaXNwb25pYmlsaWRhZChmZWNoYV9pbmljaW8sIGZlY2hhX3Rlcm1pbm8sZXN0YWRvKVxuICAgIGVsc2UgRGVzaXN0ZSBkZSBjcmVhciBsYSByZXNlcnZhXG4gICAgICAgIFNpc3RlbWFEZU1lbnNhamVyw61hIC0tPj4rIENyZWFkb3JSZXNlcnZhOiBWb2x2ZXJNZW51SW5pY2lhbCgpXG4gICAgZW5kXG4gXG4gICAgYWx0IE5vIGhheSBkaXNwb25pYmlsaWRhZFxuICAgICAgICBTaXN0ZW1hRGVNZW5zYWplcsOtYSAtPj4rIFNpc3RlbWFEZU1lbnNhamVyw61hOiBCdXNjYXJEaXNwb25pYmlsaWRhZE90cm9zSG90ZWxlcyhmZWNoYV9pbmljaW8sIGZlY2hhX3Rlcm1pbm8sZXN0YWRvKVxuICAgICAgICBTaXN0ZW1hRGVNZW5zYWplcsOtYSAtLT4-KyBDcmVhZG9yUmVzZXJ2YTogTm90aWZpY2FyRGlzcG9uaWJpbGlkYWQoKVxuICAgICAgICBDcmVhZG9yUmVzZXJ2YSAtPj4rIFNpc3RlbWFEZU1lbnNhamVyw61hOiBNb2RpZmljYXJEYXRvc1Jlc2VydmEoZmVjaGFfaW5pY2lvLCBmZWNoYV90ZXJtaW5vLCBlc3RhZG8pXG4gICAgZWxzZSBIYXkgZGlzcG9uaWJpbGlkYWQgKGVuIGhvdGVsIGRlIHN1IGNvbnZlbmllbmNpYSlcbiAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-KyBTaXN0ZW1hRGVNZW5zYWplcsOtYTogTW9kaWZpY2FyRGF0b3NSZXNlcnZhKGZlY2hhX2luaWNpbywgZmVjaGFfdGVybWlubywgZXN0YWRvKVxuICAgIGVuZFxuIFxuICAgIENyZWFkb3JSZXNlcnZhIC0-PisgU2lzdGVtYURlTWVuc2FqZXLDrWE6IFJlZ2lzdHJhclJlc2VydmEoZmVjaGFfaW5pY2lvLCBmZWNoYV90ZXJtaW5vLCBlc3RhZG8pXG4gXG4gICAgTm90ZSBvdmVyIENyZWFkb3JSZXNlcnZhLFNpc3RlbWFEZU1lbnNhamVyw61hOiBJbmNsdWlyIENVMTBcblxuXG5cblxuIiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

```
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
```

### versión 2

![ModificarReserva](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENyZWFkb3JSZXNlcnZhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlTWVuc2FqZXLDrWFcbiAgICBOb3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU2lzdGVtYURlTWVuc2FqZXLDrWE6IElkZW50aWZpY2FyIENsaWVudGUgKENVOHxDVTkpXG4gICAgTm90ZSBvdmVyIENyZWFkb3JSZXNlcnZhLFNpc3RlbWFEZU1lbnNhamVyw61hOiBJZGVudGlmaWNhciBSZXNlcnZhIGRlIENsaWVudGUgKENVNylcblxuICAgICUlIDNcbiAgICBsb29wIG1vZGlmaWNhciByZXNlcnZhXG4gICAgICAgIGxvb3AgZW5jb250cmFyIGhvdGVsIGRpc3BvbmlibGVcbiAgICAgICAgICAgIENyZWFkb3JSZXNlcnZhIC0-PiBTR0g6IGRpc3BvbmliaWxpZGFkID0gY29uZmlybWFyRGlzcG9uaWJpbGlkYWQoaG90ZWwsIHRpcG9faGFiaXRhY2lvbiwgZmluaWNpbywgZmZpbikgOiBCb29sXG4gICAgICAgICAgICBhbHQgbm8gaGF5IGRpc3BvbmliaWxpZGFkXG4gICAgICAgICAgICAgICAgQ3JlYWRvclJlc2VydmEgLT4-IFNHSDogYWx0ZXJuYXRpdmFzID0gYnVzY2FyQWx0ZXJuYXRpdmFzKHBhaXMsIHRpcG9faGFiaXRhY2lvbiwgZmluaWNpbywgZmZpbikgOiBMaXN0PEhvdGVsPlxuICAgICAgICAgICAgZW5kXG4gICAgICAgIGVuZFxuXG4gICAgICAgIGFsdCBjb25maXJtYSBtb2RpZmljYWNpb25cbiAgICAgICAgICAgIENyZWFkb3JSZXNlcnZhIC0-PiBTR0g6IG1vZGlmaWNhclJlc2VydmEoaWQsIGhvdGVsLCB0aXBvX2hhYml0YWNpb24sIGZpbmljaW8sIGZmaW4pXG4gICAgICAgICAgICBOb3RlIG92ZXIgU0dILFNpc3RlbWFEZU1lbnNhamVyw61hOiBDb25maXJtYXIgUmVzZXJ2YSAoQ1UxMClcbiAgICAgICAgZWxzZSBubyBtb2RpZmljYXIgcmVzZXJ2YVxuICAgICAgICAgICAgTm90ZSBvdmVyIENyZWFkb3JSZXNlcnZhLFNpc3RlbWFEZU1lbnNhamVyw61hOiBTVE9QXG4gICAgICAgIGVuZFxuICAgIGVuZCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)

```
sequenceDiagram 
    participant CreadorReserva
    participant SGH
    participant SistemaDeMensajería
    Note over CreadorReserva,SistemaDeMensajería: Identificar Cliente (CU8|CU9)
    Note over CreadorReserva,SistemaDeMensajería: Identificar Reserva de Cliente (CU7)

    %% 3
    loop modificar reserva
        loop encontrar hotel disponible
            CreadorReserva ->> SGH: disponibilidad = confirmarDisponibilidad(hotel, tipo_habitacion, finicio, ffin) : Bool
            alt no hay disponibilidad
                CreadorReserva ->> SGH: alternativas = buscarAlternativas(pais, tipo_habitacion, finicio, ffin) : List<Hotel>
            end
        end

        alt confirma modificacion
            CreadorReserva ->> SGH: modificarReserva(id, hotel, tipo_habitacion, finicio, ffin)
            Note over SGH,SistemaDeMensajería: Confirmar Reserva (CU10)
        else no modificar reserva
            Note over CreadorReserva,SistemaDeMensajería: STOP
        end
    end
```
### version 3

![Tarea 1.2 - Diagrama de secuencia B)]
[![](https://mermaid.ink/img/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtXG5cbnBhcnRpY2lwYW50IEh1w6lzcGVkXG5wYXJ0aWNpcGFudCBDcmVhZG9yUmVzZXJ2YVxucGFydGljaXBhbnQgU0dIXG5wYXJ0aWNpcGFudCBTaXN0ZW1hZGVNZW5zYWplcsOtYVxucGFydGljaXBhbnQgU2lzdGVtYURlRmFjdHVyYWNpw7NuXG5Ob3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU2lzdGVtYWRlTWVuc2FqZXLDrWE6IEluY2x1aXIgQ1U4IHkgQ1U5XG5Ob3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU2lzdGVtYWRlTWVuc2FqZXLDrWE6IEluY2x1aXIgQ1U3XG4gXG5hbHQgTW9kaWZpY2FyIHJlc2VydmFcbkNyZWFkb3JSZXNlcnZhIC0-PisgU0dIOiBNb2RpZmljYXJEYXRvc1Jlc2VydmEoZmksIGZ0LCBlc3RhZG8pXG5TR0ggLT4-KyBTR0g6IFZlcmlmaWNhckRpc3BvbmliaWxpZGFkKGZpLCBmdCxlc3RhZG8pXG4gICAgYWx0IE5vIGhheSBkaXNwb25pYmlsaWRhZFxuICAgIFNHSCAtPj4rIFNHSDogVmVyaWZpY2FyRGlzcG9uaWJpbGlkYWQgZW4gSG90ZWwgKGZpLCBmdCxwYcOtcylcbiAgICBcbiAgICAgICAgYWx0IE5vIGhheSBkaXNwb25pYmlsaWRhZCBkZSBob3RlbGVzXG4gICAgICAgIFNHSCAtPj4rIENyZWFkb3JSZXNlcnZhOiBObyBoYXkgZGlzcG9uaWJpbGlkYWQgZGUgaG90ZWxcbiAgICAgICAgTm90ZSBvdmVyIENyZWFkb3JSZXNlcnZhLFNpc3RlbWFkZU1lbnNhamVyw61hOiByZXRvcm5hIGEgbW9kaWZpY2FjacOzbiBkZSByZXNlcnZhXG4gICAgICAgIGVuZFxuICAgICAgICBhbHQgRGlzcG9uaWJpbGlkYWQgZGUgaG90ZWxcbiAgICAgICAgU0dIIC0-PisgQ3JlYWRvclJlc2VydmE6IGhheSBkaXNwb25pYmlsaWRhZCBkZSBob3RlbFxuICAgICAgICBOb3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU2lzdGVtYWRlTWVuc2FqZXLDrWE6IHJldG9ybmEgYSBtb2RpZmljYWNpw7NuIGRlIHJlc2VydmFcbiAgICAgICAgZW5kXG4gICAgZW5kXG5cbkNyZWFkb3JSZXNlcnZhIC0-PisgU0dIOiBDb25maXJtYSByZXNlcnZhIG8gbW9kaWZpY2EgKChmaSwgZnQsaG90ZWwsdGlwb2hhYml0YWNpb24pXG5TR0ggLT4-KyBTaXN0ZW1hRGVGYWN0dXJhY2nDs246IGFjdHVhbGl6YSBkYXRvcyBkZSB0YXJpZmFcbmVsc2Ugbm8gbW9kaWZpY2EgcmVzZXJ2YVxuU0dIIC0-PisgU2lzdGVtYWRlTWVuc2FqZXLDrWE6IGVudsOtYSBjb25maXJtYWNpw7NuIHkgZGF0b3NcblxuU0dIIC0tPj4rIENyZWFkb3JSZXNlcnZhOiBWb2x2ZXJNZW51SW5pY2lhbCgpXG5cbmVuZCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)](https://mermaid-js.github.io/mermaid-live-editor/edit##eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtXG5cbnBhcnRpY2lwYW50IEh1w6lzcGVkXG5wYXJ0aWNpcGFudCBDcmVhZG9yUmVzZXJ2YVxucGFydGljaXBhbnQgU0dIXG5wYXJ0aWNpcGFudCBTaXN0ZW1hZGVNZW5zYWplcsOtYVxucGFydGljaXBhbnQgU2lzdGVtYURlRmFjdHVyYWNpw7NuXG5Ob3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU2lzdGVtYWRlTWVuc2FqZXLDrWE6IEluY2x1aXIgQ1U4IHkgQ1U5XG5Ob3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU2lzdGVtYWRlTWVuc2FqZXLDrWE6IEluY2x1aXIgQ1U3XG4gXG5hbHQgTW9kaWZpY2FyIHJlc2VydmFcbkNyZWFkb3JSZXNlcnZhIC0-PisgU0dIOiBNb2RpZmljYXJEYXRvc1Jlc2VydmEoZmksIGZ0LCBlc3RhZG8pXG5TR0ggLT4-KyBTR0g6IFZlcmlmaWNhckRpc3BvbmliaWxpZGFkKGZpLCBmdCxlc3RhZG8pXG4gICAgYWx0IE5vIGhheSBkaXNwb25pYmlsaWRhZFxuICAgIFNHSCAtPj4rIFNHSDogVmVyaWZpY2FyRGlzcG9uaWJpbGlkYWQgZW4gSG90ZWwgKGZpLCBmdCxwYcOtcylcbiAgICBcbiAgICAgICAgYWx0IE5vIGhheSBkaXNwb25pYmlsaWRhZCBkZSBob3RlbGVzXG4gICAgICAgIFNHSCAtPj4rIENyZWFkb3JSZXNlcnZhOiBObyBoYXkgZGlzcG9uaWJpbGlkYWQgZGUgaG90ZWxcbiAgICAgICAgTm90ZSBvdmVyIENyZWFkb3JSZXNlcnZhLFNpc3RlbWFkZU1lbnNhamVyw61hOiByZXRvcm5hIGEgbW9kaWZpY2FjacOzbiBkZSByZXNlcnZhXG4gICAgICAgIGVuZFxuICAgICAgICBhbHQgRGlzcG9uaWJpbGlkYWQgZGUgaG90ZWxcbiAgICAgICAgU0dIIC0-PisgQ3JlYWRvclJlc2VydmE6IGhheSBkaXNwb25pYmlsaWRhZCBkZSBob3RlbFxuICAgICAgICBOb3RlIG92ZXIgQ3JlYWRvclJlc2VydmEsU2lzdGVtYWRlTWVuc2FqZXLDrWE6IHJldG9ybmEgYSBtb2RpZmljYWNpw7NuIGRlIHJlc2VydmFcbiAgICAgICAgZW5kXG4gICAgZW5kXG5cbkNyZWFkb3JSZXNlcnZhIC0-PisgU0dIOiBDb25maXJtYSByZXNlcnZhIG8gbW9kaWZpY2EgKChmaSwgZnQsaG90ZWwsdGlwb2hhYml0YWNpbylcblNHSCAtPj4rIFNpc3RlbWFEZUZhY3R1cmFjacOzbjogYWN0dWFsaXphIGRhdG9zIGRlIHRhcmlmYVxuZWxzZSBubyBtb2RpZmljYSByZXNlcnZhXG5TR0ggLT4-KyBTaXN0ZW1hZGVNZW5zYWplcsOtYTogZW52w61hIGNvbmZpcm1hY2nDs24geSBkYXRvc1xuXG5TR0ggLS0-PisgQ3JlYWRvclJlc2VydmE6IFZvbHZlck1lbnVJbmljaWFsKClcblxuZW5kIiwibWVybWFpZCI6IntcbiAgXCJ0aGVtZVwiOiBcImRlZmF1bHRcIlxufSIsInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)
sequenceDiagram

participant Huésped
participant CreadorReserva
participant SGH
participant SistemadeMensajería
participant SistemaDeFacturación
Note over CreadorReserva,SistemadeMensajería: Incluir CU8 y CU9
Note over CreadorReserva,SistemadeMensajería: Incluir CU7
 
alt Modificar reserva
CreadorReserva ->>+ SGH: ModificarDatosReserva(fi, ft, estado)
SGH ->>+ SGH: VerificarDisponibilidad(fi, ft,estado)
    alt No hay disponibilidad
    SGH ->>+ SGH: VerificarDisponibilidad en Hotel (fi, ft,país)
    
        alt No hay disponibilidad de hoteles
        SGH ->>+ CreadorReserva: No hay disponibilidad de hotel
        Note over CreadorReserva,SistemadeMensajería: retorna a modificación de reserva
        end
        alt Disponibilidad de hotel
        SGH ->>+ CreadorReserva: hay disponibilidad de hotel
        Note over CreadorReserva,SistemadeMensajería: retorna a modificación de reserva
        end
    end

CreadorReserva ->>+ SGH: Confirma reserva o modifica ((fi, ft,hotel,tipohabitacion)
SGH ->>+ SistemaDeFacturación: actualiza datos de tarifa
else no modifica reserva
SGH ->>+ SistemadeMensajería: envía confirmación y datos

SGH -->>+ CreadorReserva: VolverMenuInicial()

end


## (C) Tomar Reserva (para revisar)

### versión 1

![Tarea 1.2 - Diagrama de secuencia C)](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IEh1w6lzcGVkXG4gICAgcGFydGljaXBhbnQgQ2xpZW50ZVxuICAgIHBhcnRpY2lwYW50IFJlY2VwY2lvbmlzdGFcbiAgICBwYXJ0aWNpcGFudCBTR0hcbiAgICBwYXJ0aWNpcGFudCBTaXN0ZW1hRGVGYWN0dXJhY2nDs25cbiAgICBcblxuICAgIGFsdCBIdcOpc3BlZCB0aWVuZSByZXNlcnZhXG5cbiAgICAgICAgYWx0IE5pbmd1bmEgcmVzZXJ2YSBjb2luY2lkZSBjb24gbGEgaW5mb3JtYWNpw7NuIGRlbCBIdcOpc3BlZFxuICAgICAgICAgICAgTm90ZSBvdmVyIEh1w6lzcGVkLCBTaXN0ZW1hRGVGYWN0dXJhY2nDs246IEluY2x1aXIgQ1UxXG4gICAgICAgICAgICBIdcOpc3BlZCAtPj4rIFJlY2VwY2lvbmlzdGE6IEVudHJlZ2FyRGF0b3NQZXJzb25hbGVzKE5vbWJyZSwgbWFpbCwgdGVsw6lmb25vKVxuICAgICAgICBFbHNlIEhheSB1bmEgcmVzZXJ2YSBjb3Jjb25kYW50ZSBjb24gbGEgaW5mb3JtYWNpw7NuIGRlbCBIdcOpc3BlZFxuICAgICAgICAgICAgSHXDqXNwZWQgLT4-KyBSZWNlcGNpb25pc3RhOiBFbnRyZWdhckluZm9ybWFjaW9uUmVzZXJ2YShjb2RpZ28pXG4gICAgICAgICAgICBSZWNlcGNpb25pc3RhIC0-PisgU0dIOiBMb2NhbGl6YXJSZXNlcnZhKGNvZGlnbylcbiAgICAgICAgRW5kXG5cbiAgICBlbHNlIEh1w6lzcGVkIG5vIHRpZW5lIHJlc2VydmEgICAgXG5cbiAgICAgICAgTm90ZSBvdmVyIEh1w6lzcGVkLCBTaXN0ZW1hRGVGYWN0dXJhY2nDs246IEluY2x1aXIgQ1UxXG5cbiAgICAgICAgYWx0IEhheSByZXNlcnZhcyBhw7puIG5vIHRvbWFkYXNcbiAgICAgICAgICAgIFNHSCAtLT4rIFJlY2VwY2lvbmlzdGE6IE1vc3RyYXJIYWJpdGFjaW9uZXNEaXNwb25pYmxlcygpXG4gICAgICAgIEVsc2UgTm8gaGF5IHJlc2VydmFzIGHDum4gbm8gdG9tYWRhc1xuICAgICAgICAgICAgTm90ZSBvdmVyIEh1w6lzcGVkLCBTaXN0ZW1hRGVGYWN0dXJhY2nDs246IEluY2x1aXIgQ1UxXG4gICAgICAgICAgICBIdcOpc3BlZCAtPj4rIFJlY2VwY2lvbmlzdGE6IEVudHJlZ2FyRGF0b3NQZXJzb25hbGVzKE5vbWJyZSwgbWFpbCwgdGVsw6lmb25vKVxuICAgICAgICBFbmRcblxuICAgICAgICBSZWNlcGNpb25pc3RhIC0-PisgU0dIOiBTZWxlY2Npb25hckhhYml0YWNpw7NuKClcblxuICAgICAgICBhbHQgSHXDqXNwZWQgbm8gZGVzZWEgbW9kaWZpY2FyIGRhdG9zIGRlIGxhIHJlc2VydmFcbiAgICAgICAgICAgIEh1w6lzcGVkIC0-PisgUmVjZXBjaW9uaXN0YTogRW50cmVnYXJEYXRvc1BlcnNvbmFsZXMoTm9tYnJlLCBtYWlsLCB0ZWzDqWZvbm8pXG4gICAgICAgIEVsc2UgSHXDqXNwZWQgcmVxdWllcmUgbW9kaWZpY2FyIGRhdG9zIGRlIGxhIHJlc2VydmFcbiAgICAgICAgICAgIFJlY2VwY2lvbmlzdGEgLS0-KyBDbGllbnRlOiBSZXZpc2FyUGVybWlzb0NhbWJpb0RhdG9zUmVzZXJ2YUh1w6lzcGVkKE5vbWJyZV9IdcOpc3BlZClcbiAgICAgICAgICAgIGFsdCBIdcOpc3BlZCBubyB0aWVuZSBwZXJtaXNvIHBhcmEgY2FtYmlhciBkYXRvcyBkZSBsYSByZXNlcnZhXG4gICAgICAgICAgICAgICAgUmVjZXBjaW9uaXN0YSAtLT4rIEh1w6lzcGVkOiBJbmZvcm1hclByb2hpYmljacOzbigpXG4gICAgICAgICAgICAgICAgSHXDqXNwZWQgLT4-KyBSZWNlcGNpb25pc3RhOiBFbnRyZWdhckRhdG9zUGVyc29uYWxlcyhOb21icmUsIG1haWwsIHRlbMOpZm9ubylcbiAgICAgICAgICAgIEVsc2UgSHXDqXNwZWQgY29uIHBlcm1pc29zXG4gICAgICAgICAgICAgICAgTm90ZSBvdmVyIEh1w6lzcGVkLCBTaXN0ZW1hRGVGYWN0dXJhY2nDs246IEluY2x1aXIgQ1UyXG4gICAgICAgICAgICAgICAgSHXDqXNwZWQgLT4-KyBSZWNlcGNpb25pc3RhOiBFbnRyZWdhckRhdG9zUGVyc29uYWxlcyhOb21icmUsIG1haWwsIHRlbMOpZm9ubylcbiAgICAgICAgICAgIEVuZFxuICAgICAgICBFbmRcblxuICAgICAgICBSZWNlcGNpb25pc3RhIC0-PisgU0dIOiBFbnRyZWdhckRhdG9zUGVyc29uYWxlcyhOb21icmUsIG1haWwsIHRlbMOpZm9ubylcbiAgICAgICAgU0dIIC0-PisgU0dIOiBBc2lnbmFySGFiaXRhY2nDs24oTm9tYnJlX0h1ZXNwZWQpXG4gICAgICAgIFNHSCAtPj4rIFNpc3RlbWFEZUZhY3R1cmFjacOzbjogRmFjdHVyYXJFc3RhZMOtYShOb21icmVfSHVlc3BlZClcbiAgICBlbmRcblxuXG4iLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

```
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

## (C) Tomar Reserva (para revisar) 

Construir los Diagramas de Secuencia del Sistema, expresándolos mediante diagramas de secuencia de UML, para el caso de uso Tomar Reserva (CU4).

### versión 1

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

![Tarea 1.2 - Diagrama de secuencia D)](https://mermaid.ink/svg/eyJjb2RlIjoic2VxdWVuY2VEaWFncmFtIFxuICAgIHBhcnRpY2lwYW50IENsaWVudGVcbiAgICBwYXJ0aWNpcGFudCBSZWNlcGNpb25pc3RhXG4gICAgcGFydGljaXBhbnQgU0dIXG4gICAgcGFydGljaXBhbnQgU2lzdGVtYURlRmFjdHVyYWNpw7NuXG4gIFxuICAgIENsaWVudGUgLT4-KyBSZWNlcGNpb25pc3RhOiBFbnRyZWdhckRhdG9zUmVzZXJ2YShjb2RpZ28sIG5vbWJyZV9jbGllbnRlLCBmZWNoYV9jaGVja19pbiwgZmVjaGFfY2hlY2tfb3V0KVxuICAgIFJlY2VwY2lvbmlzdGEgLT4-KyBTR0g6IENvbnN1bHRhclJlc2VydmFQb3JJRChjb2RpZ28pXG5cbiAgICBhbHQgTm8gc2UgdGllbmUgcmVzZXJ2YSByZWdpc3RyYWRhXG4gICAgICAgIFNHSCAtLT4rIFJlY2VwY2lvbmlzdGE6IERldm9sdmVyUmVzZXJ2YU5vRW5jb250cmFkYShtZW5zYWplKVxuICAgICAgICBSZWNlcGNpb25pc3RhIC0tPitDbGllbnRlOiBEZXZvbHZlclJlc2VydmFOb0VuY29udHJhZGEobWVuc2FqZSlcbiAgICBlbHNlIFNlIHRpZW5lIHJlc2VydmEgcmVnaXN0cmFkYVxuICAgICAgICBTR0ggLS0-KyBSZWNlcGNpb25pc3RhOiBEZXZvbHZlckRhdG9zUmVzZXJ2YSgpXG4gICAgZW5kXG5cbiAgICBSZWNlcGNpb25pc3RhIC0-PisgU0dIOiBBbnVsYXJSZXNlcnZhKGNvZGlnbylcblxuICAgIGFsdCBObyBzZSBoYSBsbGVnYWRvIGEgZmVjaGEgZGUgc2VyIHRvbWFkYVxuICAgICAgICBTR0ggLS0-KyBSZWNlcGNpb25pc3RhOiBEZXZvbHZlckVzdGFkb1Jlc2VydmEobWVuc2FqZSlcbiAgICBlbHNlIFNlIGxsZWfDsyBhIGxhIGZlY2hhIGRlIHNlciB0b21hZGFcbiAgICAgICAgU0dIIC0-PisgU2lzdGVtYURlRmFjdHVyYWNpw7NuOiBTb2xpY2l0YXJSZWVtYm9sc28oY29kaWdvLCBkaWFzX3Jlc3RhbnRlcylcbiAgICAgICAgU2lzdGVtYURlRmFjdHVyYWNpb24gLS0-KyBTR0g6IEVudHJlZ2FSZWVtYm9sc28oY29kaWdvLCBjb2RpZ29fb3BlcmFjaW9uLCBjdWVudGEsIG1vbnRvKVxuICAgICAgICBTR0ggLT4-KyBTR0g6IFByb2Nlc2FyQW51bGFjaW9uKGNvZGlnbywgY3VlbnRhLCBtb250bylcbiAgICAgICAgU0dIIC0tPisgUmVjZXBjaW9uaXN0YTogRGV2b2x2ZXJFc3RhZG9SZXNlcnZhKG1lbnNhamUpXG4gICAgZW5kXG4gXG5cblxuXG5cblxuIiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)

```
sequenceDiagram 
    participant Cliente
    participant Recepcionista
    participant SGH
    participant SistemaDeFacturación
  
    Cliente ->>+ Recepcionista: EntregarDatosReserva(codigo, nombre_cliente, fecha_check_in, fecha_check_out)
    Recepcionista ->>+ SGH: ConsultarReservaPorID(codigo)
    alt No se tiene reserva registrada
        SGH -->+ Recepcionista: DevolverReservaNoEncontrada(mensaje)
        Recepcionista -->+Cliente: DevolverReservaNoEncontrada(mensaje)
    else Se tiene reserva registrada
        SGH -->+ Recepcionista: DevolverDatosReserva()
    end
    Recepcionista ->>+ SGH: AnularReserva(codigo)
    alt No se ha llegado a fecha de ser tomada
        SGH -->+ Recepcionista: DevolverEstadoReserva(mensaje)
    else Se llegó a la fecha de ser tomada
        SGH ->>+ SistemaDeFacturación: SolicitarReembolso(codigo, dias_restantes)
        SistemaDeFacturacion -->+ SGH: EntregaReembolso(codigo, codigo_operacion, cuenta, monto)
        SGH ->>+ SGH: ProcesarAnulacion(codigo, cuenta, monto)
        SGH -->+ Recepcionista: DevolverEstadoReserva(mensaje)
    end
```

## (E) Máquina de Estados (para revisar) 

Construir, para el caso de uso Hacer Reserva (CU1), una máquina de estados que represente el estado del sistema en la interacción con los actores.
