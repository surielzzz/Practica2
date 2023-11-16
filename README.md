#HOTEL DE MARTOS

Este programa simula el gestionamiento de un hotel en Martos. Cuenta con dos menús: un menú principal y otro menú para los administradoresen el cual se accede solamente con un usuario y contraseña.

----------------
Abriendo el documento adjuntado y seleccionado el archivo llamado "Practica2.bat" podremos abrir el programa del simualdor en una terminal de Windows y comenzar a utilizarlo, pero antes de eso, le recomendamos que se tome unos minutos para leer estas simples instrucciones de su uso.

El programa te recibirá con un cartel con el nombre del hotel.

![](https://media.discordapp.net/attachments/1158081124447301793/1174487711269257267/Captura_de_pantalla_2023-11-16_000226.png?ex=6567c5eb&is=655550eb&hm=7872c2a7423cc618b5d52bbe4b9419c4b5062ff438d5011dcc22b1fad3494f84&=)

Por consiguiente, te saldrá un menú principal con totas las opcciones generales disponibles.

![](https://media.discordapp.net/attachments/1158081124447301793/1174487740092534915/Captura_de_pantalla_2023-11-16_000324.png?ex=6567c5f2&is=655550f2&hm=ce858eb3a9c2f0532170c109f6eef1c294c739e66d3c012a70e00b55cf3dab5d&=)

En la sección "a"  se muestra un listado con el estado de todas las habitaciones, muestra si están ocupadas o no, cada que se haga una reserva, el listado cambiará de "libre" a "ocupado".

![](https://media.discordapp.net/attachments/1158081124447301793/1174487807541133373/Captura_de_pantalla_2023-11-16_000349.png?ex=6567c602&is=65555102&hm=341e6bc7bb2222f2b5de91afd18968264e53ccb5ab8ec2282831c58e8bec5277&=&width=508&height=418)

Pulsando cualquier letra y dándole al "enter" te podrás redireccionar nuevamente al menú principal donde podrás seguir utilizando el programa.

En la sección "b" se muestra el proceso de la reservación. Lo primero que se mostrará en pantalla será un mini menú dando las opciones de "individual" o "doble" para los tipos de habitaciones.

![](https://media.discordapp.net/attachments/1158081124447301793/1174487849857470535/Captura_de_pantalla_2023-11-16_000448.png?ex=6567c60c&is=6555510c&hm=688d53a4c50a68c703530dbe391783d3e24863fb95e047727cc636bd88502f56&=)

En ambas opciones te pide los mismos datos: primer nombre, segundo nombre y DNI. Es muy importante asegurarnos que los datos estén introducidos de forma correcta. Al finalizar de llenar los datos saldrá un mensaje diciendo "HABITACIÓN --- RESERVADA. Gracias por su reservación. Introduzca el número 3 para continuar: ", siguiendo los pasos que nos brinda el programa volveremos a estar en el menú principal.

En la sección "c" realizaremos el checkout de la habitación, igual que en la anterior sección, se pedirán datos como el nombre, apellido, ID, sumándole la fecha de salida (IMPORTANTE: deben los datos coincidir para que la acción se realice de manera fructífera, si los datos en el checkout no coinciden con los de la reserva, saldrá un error y te pedirá que lo hagas de nuevo), ya introducida la fecha, se mostrará por pantalla la factura:

![](https://media.discordapp.net/attachments/1158081124447301793/1174507571030278194/Captura_de_pantalla_2023-11-16_013000.png?ex=6567d86a&is=6555636a&hm=99115791731f3a3d001bd934c5a73ee35636f78645f977ff553dee5b6bd26d50&=&width=375&height=336)

A continuación, se le pedirá que introduzca la cantidad en efectivo con que desea pagar para después proporcionarle el cambio obtenido. Cuando esa acción sea realizada volveremos al menú principal para entrar a la última sección del programa.

En la sección "d" se abrirá el menú del adminstrador únicamente si el usuario y contraseña introducidos son correctos (el usuario es "canela" y la clave es "1961"), cuando entres al menú administrativo tendrás 3 opciones: cosultar cantidad total de ingresos y reservas, consultar monedas restantes y apagar sistema.

![](https://media.discordapp.net/attachments/1158081124447301793/1174507678270226512/Captura_de_pantalla_2023-11-16_013103.png?ex=6567d883&is=65556383&hm=6a69a55cd2e5dcd4784ba47b7cae5b5e127d406e04c09cfbc5c77189a221c69c&=&width=375&height=126)

En la sección "a" se desplega unos recuadros con los ingresos totales y el número de reservas actuales, dependiendo las cantidades actuales de reservas, los recuadros se actualizarán.

![](https://media.discordapp.net/attachments/1158081124447301793/1174507678517702706/Captura_de_pantalla_2023-11-16_013119.png?ex=6567d883&is=65556383&hm=7b6183492d876665ecc1a1fc42f032c4079163ef041a10758199a153cde192db&=&width=322&height=123)

Pulsando una tecla cualquiera volvemos al menú principal donde volveremos a elegir la opción "d" e ingresaremos el usuario y contraseña. Cada acción terminada de realizar en el menú administrativo nos manadará al principal por medidas de seguridad, así que constantemente estaremos que estar iniciando sección. 

Introduciremos la opción "b" para consultar las monedas restantes.

![](https://media.discordapp.net/attachments/1158081124447301793/1174507678773547158/Captura_de_pantalla_2023-11-16_013206.png?ex=6567d883&is=65556383&hm=7bc455d82802338271185d6753517bdbad93d51c9a828b73fe00448826fa3c9e&=&width=339&height=411)

Y ya por último en la sección "c" es para apagar el programa, tan simple como seleccionar la opción y esperar que se ejecute éxitosamente el cierre.
Una vez apagado el programa se saldrá automáticamente de la terminal de Windows, si desea volver a probarlo deberá de abrir de nuevo el programa desde el ".bat".

Siendo este un pequeño y siemple (pero efectivo) recorrido en este simulador de gestión administrativa de un hotel.
Recordar que este es solo una versión beta, cualquier error dado en el programa se irá resolviendo con el mantenimiento necesario.

En la carpeta adjuntada donde se encuentra el archivo ".bat", si le damos a la carpeta "salida/Produccion/PracticaObligatoria2" nos encontraremos con el programa en ".class" y dándole a la caperta "src" nos encontraremos el archivo en ".java", por si alguien le interesa ver como funciona el simulador por dentro.


Zamira Suriel - 1°DAM. Práctica Obligatoria 2.
