# Equipo de Desarrollo Software

## Enunciado
Una empresa de desarrollo de software, cansada de usar Excel para gestionar los equipos de trabajo, decide crear su propia aplicación para este propósito, la cual, además, espera comercializar a medio plazo. Para estudiar su utilidad, se propone iniciar el desarrollo con un prototipo sencillo, que modela la estructura básica de los equipos. 

Para ello se propone una clase base `TeamMember`, que representa los roles que pueden encontrarse en el equipo de trabajo. Esta clase dispone de:
- Un campo identificador único (de tipo entero).
- Un campo que representa el nombre completo (de tipo cadena de texto).

El esquema lo completan las clases `TeamLeader`, `TeamDeveloper` y `TeamWriter`. Estas tres extienden a la clase `TeamMember`.

- **`TeamDeveloper`** representa un miembro del equipo de desarrollo. Además de los campos de `TeamMember`, dispone de un campo de tipo cadena de texto que representa el nombre de la tecnología que domina de forma preferencial (Java, Python, Javascript, HTML, ...).
- **`TeamWriter`** representa un miembro del equipo que se dedica exclusivamente a redactar documentación técnica de los productos. No posee ningún campo adicional a `TeamMember`.
- **`TeamLeader`** representa al responsable de un equipo de trabajo que puede gestionar varios miembros de tipo `TeamDeveloper` y `TeamWriter`. En adición a los campos de `TeamMember`, dispone de una colección con los miembros del equipo que gestiona. A esta colección se pueden añadir y eliminar miembros a medida que evoluciona el proyecto. Asimismo, dispone de funciones para obtener listados ordenados de los componentes del equipo.

## Ejercicio a realizar
El ejercicio a realizar consiste en el desarrollo de las clases que se describen a continuación. De todas ellas, además, se pide documentar usando la sintaxis de Javadoc la clase `TeamMember`.

Todas las clases del modelo se ubican en el paquete `tp.examen`.

### Clase abstracta `TeamMember` (2,25 puntos)
- Un **constructor** al que se le pasa por parámetro el nombre de la persona en forma de cadena de texto. El identificador se obtiene usando el método estático `getUniqueId()` de la clase `TeamMemberUtils`.
- Un método llamado `getId()` que devuelve el identificador de la persona.
- Un método llamado `getName()` que devuelve el nombre de la persona.
- Nueva implementación del método `toString()`, de forma que retorne una cadena con el identificador y el nombre separados por una coma. Ejemplo: `1,María`
- Un método **abstracto** llamado `getDuties()` que devuelve una cadena de texto que describe las funciones del miembro del equipo.

### Clase `TeamDeveloper` (0,5 puntos)
Además de los campos y métodos heredados dispone de los siguientes métodos:
- Un **constructor** al que se le pasan por parámetro el nombre de la persona, y el nombre de la tecnología que domina, también como cadena de texto.
- El método `getTechnology()`, que retorna el nombre de la tecnología que domina.
- El método `getDuties()`, que retorna una cadena formada por el identificador, una coma, el nombre de la persona, una coma, y un texto del tipo "Desarrollo en [Nombre Tecnología]". Ejemplo: `1,Jane,Desarrollo en Java`. Si es posible, **reutilizar** métodos para la elaboración de la cadena.

### Clase `TeamWriter` (0,25 puntos)
Además de los campos y métodos heredados dispone de los siguientes métodos:
- Un **constructor** al que se le pasa por parámetro el nombre de la persona.
- El método `getDuties()`, que retorna una cadena formada por el identificador, una coma, el nombre de la persona, una coma, y el texto "Redactar documentación". Ejemplo: `1,John,Redactar documentación`. Si es posible, **reutilizar** métodos para la elaboración de la cadena.

### Clase `TeamLeader` (7 puntos)
Además de los métodos y campos heredados dispone de los siguientes métodos:
- Un **constructor** al que se le pasa por parámetro el nombre de la persona.
- Un método llamado `isMember(...)` al que se le pasa por parámetro un objeto `TeamMember` y retorna `false` si el valor de entrada es `null` o no está contenido en el grupo; y `true` en caso contrario. (1 punto)
- Un método llamado `add(...)` al que se le pasa por parámetro un `TeamMember` a añadir. Devuelve `false` si:
  1. el valor de entrada es `null`;
  2. si no es de tipo `TeamDeveloper` o `TeamWriter`;
  3. o si dicha persona ya está contenida en su grupo. En caso contrario, el nuevo miembro se añade y el método retorna `true`. (1,5 puntos)
- Un método llamado `remove(...)` al que se le pasa por parámetro un identificador de un miembro y lo elimina del equipo. Retorna `true` si el miembro es eliminado; y `false` si el identificador es negativo o no existe un miembro con ese identificador. (0,5 puntos)
- Un método llamado `getMembers()` que devuelve una lista con los miembros del equipo ordenada por el nombre de la persona, y en caso de que dos miembros se llamen igual, por el identificador. En la lista que se retorna **debe** incluirse el propio `TeamLeader`. En caso de modificar la lista devuelta no se debería modificar el contenido de `TeamLeader`. (2 puntos)
- El método `getDuties()`. Si el equipo de trabajo está vacío, debe retornar la cadena `"Equipo vacío"`. En caso contrario, debe retornar una cadena de texto del tipo `"Responsable de:"`, y a continuación una línea por cada uno de los miembros del equipo que consista en la cadena que retorna el método `getDuties()` de la clase correspondiente. La lista debe estar **ordenada por identificador**. (2 puntos)

  Ejemplo:
  ```
  Responsable de:
  
  1,María,Desarrollo en Java 
  
  2,Juan,Redactar Documentación
  ``` 


## Uso y prueba de las clases
El método `main` de la clase pública `UseTeamMember` funciona como punto de entrada del programa. Puede usar el mismo para realizar las pruebas que considere necesarias sobre el código desarrollado. Asimismo, puede usar el código que ya se incluye comentado en el método `main`.

La clase `TeamMemberUtils` ya está definida en el paquete `tp.examen`. No es necesario importarla.

## Notas
- El código no debe tener errores de compilación. Estos pueden penalizar de 2 a 4 puntos.
- Las distintas clases se deben desarrollar según los requisitos descritos en el enunciado, añadiendo los métodos de la clase `Object` y **comparadores** que crea oportunos para su correcto funcionamiento en el resto de la aplicación.
- Use los **contenedores** de Java más adecuados para este escenario.
- Para la implementación de los **comparadores** se deben implementar las interfaces usando clases, **clases anidadas**, clases anónimas o lambdas.
- **No está permitido** el uso de métodos estáticos de utilidades de la clase `Comparator` del tipo `comparing…`, `thenComparing…` y similares.
- Se puede modificar el método `main` de `UseTeamMember` para realizar todas las pruebas que requiera.
