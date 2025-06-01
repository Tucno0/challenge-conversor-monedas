# 💱 Conversor de Monedas - Challenge Alura LATAM

![Java](https://img.shields.io/badge/Java-17+-blue)
![API](https://img.shields.io/badge/API-ExchangeRate-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

## 📋 Descripción

Este proyecto es parte del **Challenge de Alura LATAM**, donde se desarrolla un conversor de monedas funcional que consume una API de tasas de cambio en tiempo real. La aplicación permite convertir entre diferentes monedas sudamericanas y el dólar estadounidense.

## 🎯 Objetivo del Challenge

En este emocionante desafío de programación, se construye un Conversor de Monedas completo que:

- ✅ Realiza solicitudes a una API de tasas de cambio
- ✅ Manipula datos JSON
- ✅ Filtra y muestra las monedas de interés
- ✅ Proporciona una interfaz de usuario intuitiva

## 🚀 Funcionalidades

### Conversiones Disponibles:

1. **Dólar (USD)** ↔ **Sol Peruano (PEN)**
2. **Dólar (USD)** ↔ **Peso Argentino (ARS)**
3. **Dólar (USD)** ↔ **Real Brasileño (BRL)**
4. **Dólar (USD)** ↔ **Peso Colombiano (COP)**

### Características Principales:

- 🔄 Conversión bidireccional entre monedas
- 📊 Tasas de cambio actualizadas en tiempo real
- 🛡️ Manejo robusto de errores
- 💻 Interfaz de consola amigable
- ⚡ Respuestas rápidas mediante API REST

## 🛠️ Tecnologías Utilizadas

- **Java 17+**: Lenguaje de programación principal
- **HttpClient**: Para realizar peticiones HTTP a la API
- **Gson**: Para el parsing de respuestas JSON
- **ExchangeRate-API**: API externa para obtener tasas de cambio

## 📁 Estructura del Proyecto

```
challenge-conversor-monedas/
├── src/
│   ├── Principal.java              # Clase principal con la interfaz de usuario
│   ├── ConsultaTipoCambio.java     # Servicio para consumir la API
│   └── ExchangeRateResponse.java   # Record para mapear la respuesta JSON
├── gson-2.13.1.jar                # Librería Gson
└── README.md                       # Documentación del proyecto
```

## 🔧 Configuración e Instalación

### Prerrequisitos

- Java 17 o superior
- IDE de Java (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Pasos de Instalación

1. **Clonar el repositorio**

   ```bash
   git clone [URL_DEL_REPOSITORIO]
   cd challenge-conversor-monedas
   ```

2. **Configurar el proyecto**

   - Abrir el proyecto en tu IDE favorito
   - Asegurar que la librería `gson-2.13.1.jar` esté en el classpath

## 🎮 Uso de la Aplicación

1. Al ejecutar el programa, se mostrará un menú con las opciones de conversión
2. Seleccionar el número correspondiente a la conversión deseada (1-8)
3. Ingresar el valor a convertir
4. Ver el resultado de la conversión
5. Repetir el proceso o seleccionar "9" para salir

### Ejemplo de Uso:

```
****************************************************************
Sea bienvenido/a al Conversor de Moneda =]

1) Dolar            =>>     Sol peruano
2) Sol peruano      =>>     Dólar
3) Dólar            =>>     Peso argentino
4) Peso argentino   =>>     Dólar
5) Dólar            =>>     Real brasileño
6) Real brasileño   =>>     Dólar
7) Dólar            =>>     Peso colombiano
8) Peso colombiano  =>>     Dólar

9) Salir
****************************************************************

Elija una opción válida: 1
Por favor, ingrese el valor a convertir: 100

El valor 100.0 [USD] corresponde al valor final de ==> 375.50 [PEN]
```

## 🏗️ Arquitectura del Código

### Clases Principales:

#### `Principal.java`

- **Responsabilidad**: Interfaz de usuario y lógica de control
- **Métodos principales**:
  - `main()`: Punto de entrada del programa
  - `mostrarMenu()`: Muestra las opciones disponibles
  - `mostrarResultadoConversion()`: Procesa y muestra los resultados

#### `ConsultaTipoCambio.java`

- **Responsabilidad**: Comunicación con la API de tasas de cambio
- **Método principal**:
  - `obtenerTasasDeConversion()`: Realiza la petición HTTP y retorna los datos

#### `ExchangeRateResponse.java`

- **Responsabilidad**: Modelo de datos para la respuesta de la API
- **Tipo**: Record de Java para mapear la respuesta JSON

## 🔗 API Utilizada

**ExchangeRate-API**: `https://v6.exchangerate-api.com/`

### Endpoint utilizado:

```
GET https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{BASE_CURRENCY}
```

### Respuesta JSON:

```json
{
  "result": "success",
  "base_code": "USD",
  "conversion_rates": {
    "PEN": 3.75,
    "ARS": 850.25,
    "BRL": 5.2,
    "COP": 4200.5
  }
}
```
