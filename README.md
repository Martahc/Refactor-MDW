# Movies

## Refactoring: Movies

## <em>**Versión 1.**</em> Clase “Customer” - Método “statement()”

### <em>**Smell code**</em>:
####  Método largo => más de 15 líneas
- Mal reparto de responsabilidades => Falta de Cohesión
- Imposible reutilizar para otro formato (HTML) => Inmóvil
  * copy+paste => DRY
- Cambio de política de coste y puntos => 
  * Viscoso
- copy+paste => multiplica y complica el mantenimiento

### <em>**Refactoring**</em>: 

Extraer Método => switch y código dependiente en método “amountFor” de clase Customer|

![claseCustomer](/out/docs/diagrams/src/movies/movies.svg) 

## <em>**Versión 2.**</em> Clase “Customer“ - Método “amountFor()“

### <em>**Smell code:**</em>

- Malos nombres => “each” y “thisAmount”

### <em>**Refactoring:**</em>

- Renombrar variable => “rental” y “result”

![claseCustomer](/out/docs/diagrams/src/movies2/movies.svg)

## <em>**Versión 3.**</em> Clase “Customer“ - Método “amountFor()“

### <em>**Smell Code:**</em>

- Envidia de características => get(), get(), … desde el servidor

- Clase de Datos => get(), get(), … en el cliente
Experto en Información => la clase responsable es la que tiene la información

### <em>**Refactoring**</em>

- Mover método => método “getCharge” a clase “Rental”

## <em>**Versión 4.**</em> Clase “Customer“ – Método “amountFor()“

### <em>**Smell Code:**</em>

- “Innecesaria descomposición”: método privado sin justificación

### <em>**Refactoring**</em>

- Método en línea => eliminar “amountFor”

![claseCustomer](/out/docs/diagrams/src/movies4/movies.svg)


## <em>**Versión 5.**</em> Clase “Customer“ – Método “statement()“

### <em>**Smell Code:**</em>

- Variable temporal innecesaria => “thisAmount”

### <em>**Refactoring**</em>

- Reemplazar Temporal por Consulta => “each.getCharge()”

![claseCustomer](/out/docs/diagrams/src/movies5/movies.svg)

## <em>**Versión 6.**</em> Clase “Customer“ – Método “statement()“

### <em>**Smell Code:**</em>

- Método largo => más de 15 líneas

### <em>**Refactoring**</em>

- Extraer método => método “getFrequentRenterPoints()“ a clase “Rental”

## <em>**Versión 7.**</em> Clase “Customer“ – Método “statement()“

### <em>**Smell Code:**</em>

- Variable temporal innecesaria => “totalAmount”

### <em>**Refactoring**</em>

- Reemplazar Temporal por Consulta => “this.getTotalCharge()”

![claseCustomer](/out/docs/diagrams/src/movies7/movies.svg)


## <em>**Versión 8.**</em> Clase “Customer“ – Método “statement()“

### <em>**Smell Code:**</em>

- Variable temporal innecesaria => “frequentRenterPoints”

### <em>**Refactoring**</em>

- Reemplazar Temporal por Consulta =>  “this.getTotalFrequentRenterPoints()”

![claseCustomer](/out/docs/diagrams/src/movies8/movies.svg)


## <em>**Versión 9.**</em> Clase “Rental“ – Método “getCharge()“

### <em>**Smell Code:**</em>

- Experto en la Información => la mayor parte de la información es de Movie

### <em>**Refactoring**</em>

- Mover Método => método “getCharge()” a clase “Movie”

![claseCustomer](/out/docs/diagrams/src/movies9/movies.svg)

## <em>**Versión 10.**</em> Clase “Rental“ – Método “getFrequentRenterPoints()“

### <em>**Smell Code:*</em>

- Experto en la Información => la mayor parte de la información es de Movie

### <em>**Refactoring**</em>

- Mover Método => método “getFrequentRenterPoints()” a clase “Movie”

![claseCustomer](/out/docs/diagrams/src/movies10/movies.svg)


## <em>**Versión 11.**</em> Clase “Movie“ – Método “getCharge()“

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Código de Tipo con Estrategia/Estado (inyección de dependencias) => Auto-encapsular campo => “priceCode”

![claseCustomer](/out/docs/diagrams/src/movies11/movies.svg)


## <em>**Versión 12.**</em> Clase “Movie“ – Método “getCharge()“

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Código de Tipo con Estrategia/Estado (inyección de dependencias) => Añadir nuevas clases => “Price”, “ChildrenPrice”, ...

## <em>**Versión 13.**</em> Clase “Movie” - Atributo “priceCode”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Código de Tipo con Estrategia/Estado (inyección de dependencias) => Sustituir atributo: “int priceCode” por “Price price”


![claseCustomer](/out/docs/diagrams/src/movies13/movies.svg)

## <em>**Versión 14.**</em> Clase “Movie” - método “getCharge()”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Código de Tipo con Estrategia/Estado (inyección de dependencias) => Mover método: método “getCharge()” a  Clase “Price”

![claseCustomer](/out/docs/diagrams/src/movies14/movies.svg)


## <em>**Versión 15.**</em> Clase “Price” - método “getCharge()”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Condicional con Polimorfismo => Redefinir método “getCharge()” en clases derivadas

![claseCustomer](/out/docs/diagrams/src/movies15/movies.svg)


## <em>**Versión 16.**</em> Clase “Price” - método “getFrequentRenterPoints()”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Condicional con Polimorfismo => Redefinir método “getFrequentRenterPoints()” en clases derivadas

![claseCustomer](/out/docs/diagrams/src/movies16/movies.svg)

## <em>**Versión 17.**</em> Clase “CustomerTest” - métodos de prueba con Tipo/Código

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Ocultar campo: añadir métodos “childrens()”, “regular()” y “newRelease()” en clase “MovieBuilder

![claseCustomer](/out/docs/diagrams/src/movies17/movies.svg)

## <em>**Versión 18.**</em> Clase “CustomerTest” - métodos de prueba con Tipo/Código

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

-	Ocultar campo: desde “CustomerTest” llamar a métodos “childrens()”, “regular()” y “newRelease()” de clase “MovieBuilder”
-	Sustituir campo: atributo “priceCode” por “Price” en clase “MovieBuilder”
-	Sustituir campo: atributo “priceCode” por “Price” en clase “Movie”

## <em>**Versión 19.**</em> Clase “Price” - método “getPriceCode()”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Eliminar método: “getPriceCode()” de clases “Price” y “Movie”

## <em>**Versión 20.**</em> Jerarquía “Price”

### <em>**Smell Code:**</em>

- Números mágilos => 2, 1.5, ...

### <em>**Refactoring**</em>

- Añadir atributo: “CHARGE”, “DAYS_RENTER_THRESHOLD”, ... en jerarquía “Price”

![claseCustomer](/out/docs/diagrams/src/movies20/movies.svg)

## <em>**Versión 21**</em>


![claseCustomer](/out/docs/diagrams/src/movies21/movies.svg)

## <em>**Versión 22.**</em> Clase "Customer" - Método "statement()"

### <em>**Smell Code:**</em>

- Concatenación de cadenas =>  en el metodo "statement()"

### <em>**Refactoring**</em>

- Reemplazar concatenación con StringBuilder

![claseCustomer](/out/docs/diagrams/src/movies22/movies.svg)

## <em>**Versión 23.**</em> Clase "Customer" - Reemplazo de bucles Iterator por for-each

<em>Smell Code:</em>
Uso de bucles Iterator en los métodos statement(), getTotalCharge() y getTotalFrequentRenterPoints() de la clase Customer.

### <em>**Refactoring**</em>

- Simplificación del código al utilizar bucles for-each en lugar de bucles Iterator.

![claseCustomer](/out/docs/diagrams/src/movies23/movies.svg)

## <em>**Versión 24.**</em> Clase "Customer" - Encapsulación de bucle en método aparte

### <em>**Smell Code:**</em>
Existe duplicidad de código en el bucle del metodo statement() de la clase Customer. 

### <em>**Refactoring**</em>

- Extracción del bucle del método statement() a un nuevo método llamado getRentalRecord().

![claseCustomer](/out/docs/diagrams/src/movies24/movies.svg)

## <em>**Versión 25.**</em> Clase "Customer" - Encapsulación de bucles en métodos privados

### <em>**Smell Code:**</em>
Existe duplicidad de código en los métodos getTotalCharge() y getTotalFrequentRenterPoints() de la clase Customer. 

### <em>**Refactoring**</em>

- Encapsulación de los bucles en métodos privados para mejorar la legibilidad y la cohesión del código.
- Eliminacion de la duplicidad de los bucles
- Utilización de la interfaz funcional ToDoubleFunction para el cálculo del total en el método calculateTotal().

## <em>**Versión 26.**</em> Eliminación de la clase "Price" y sus derivadas

### <em>**Smell Code:**</em>

Presencia de una jerarquía de clases redundante representada por la clase abstracta Price y sus subclases concretas (RegularPrice, ChildrenPrice y NewReleasePrice).

### <em>**Refactoring**</em>

- Se ha eliminado la clase "Price" y sus derivadas ("RegularPrice", "ChildrenPrice" y "NewReleasePrice").
- Ahora, la clase "Movie" en lugar de tener un atributo "Price", tiene tres clases que heredan de ella: "ChildrenMovie", "RegularMovie" y "NewReleaseMovie".
- La clase `MovieBuilder`  se ha convertido en abstracta.
- Actualizar  métodos `childrens()`, `regular()` y `newRelease()` en la clase `MovieBuilder` .
- Actualizar el método `build()` para que devuelva la instancia de `Movie` creada según el tipo de película seleccionado en el `MovieBuilder`.

## <em>**Versión 27.**</em> Simplificación de los métodos en "RegularMovie" y "ChildrenMovie"

<em>Smell Code:</em>
Extension innecesaria del codigo en los metodos getCharge() de las clases "RegularMovie" y "ChildrenMovie". 

### <em>**Refactoring**</em>

- Los métodos de cálculo de cargos en las clases "RegularMovie" y "ChildrenMovie" se han reescrito en una sola línea, utilizando operadores ternarios.


## <em>**Versión 28.**</em> Actualización dinámica de la cantidad total en el StatementBuilder

### <em>**Smell Code:**</em>

- Metodo totalAmount() de la clase StatementBuilder innecesario y aumenta la complejidad.


### <em>**Refactoring**</em>

- En el método `movie(String movie, double amount)` del StatementBuilder de los tests, ahora la cantidad total se calcula dinámicamente mediante el método `updateTotalAmount(double amount)`.
- El método `movie(String movie, double amount)` ahora actualiza la cantidad total cada vez que se agrega una nueva película.
- La creación del StatementBuilder en el Customertest ya no incluye el método `.totalAmount()`.

## <em>**Versión 29.**</em> Uso de StringBuilder y método para generar el registro de alquiler en el StatementBuilder

### <em>**Smell Code:**</em>

Concatenación de cadenas con el operador + en el método build() del StatementBuilder.

### <em>**Refactoring**</em>

- En el método `build()` del StatementBuilder, se ha cambiado el uso de la concatenación de cadenas con el operador `+` por el uso de StringBuilder para mejorar la eficiencia y la legibilidad del código.
- Se ha agregado un método `getRentalRecord()` en el StatementBuilder para encapsular la lógica de generación del registro de alquiler.

## <em>**Versión 30.**</em> Utilización de LinkedHashMap en StatementBuilder

### <em>**Smell Code:**</em>

Division de la informacion en dos estructuras de datos innecesariamente.

### <em>**Refactoring**</em>

- En la clase StatementBuilder, se ha reemplazado el uso de dos listas separadas (`movieNames` y `amounts`) por un solo mapa.
- Se ha utilizado un `LinkedHashMap<String, Double>` para almacenar los nombres de las películas como claves y sus cantidades como valores asociados.



