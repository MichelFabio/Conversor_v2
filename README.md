# Conversor_v2
Creación de un conversor general, que permite implementar cualquier tipo de conversor (masa,temperatura,energia,etc).
En este proyecto impulsado por ALURA se solicita crear un conversor de monedas, tomando la idea básica del proyecto se implementó un conversor de tipo general.
Este proyecto cuenta con una clase Conversor que instancia todos los componentes de java swing necesarios para la aplicación.
De esta clase conversor herendan los distintos tipos de conversores que se deseen implementar y por medio del constructor padre se envian los valores específicos de cada conversor para inicializar los JComboBox.
Cada clase hija implementa la interfaz Convertible que posee dos métodos obligatorios (convertir y setValorSalida) y un método estático que verifica que los valores ingresados sean del tipo numérico.
Para el conversor de moneda se consume la API Exchangerate-API https://app.exchangerate-api.com/dashboard, toda la conexion se implementa en la case ConexionCurrencyApi.
Los datos se guardan en un Map anidado, permitiendo manipular los datos mas facilmente

Si se desea añadir un nuevo conversor, se debe heredar de Conversor e inicializar los comboBox por medio del super e implementar la interfaz Convertible, dentro de la inicializacion de los botones conversor se puede implementar la funcionalidad específica de cada conversor

