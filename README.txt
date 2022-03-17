# README.txt
#
# Copyright (C) 2012-2022 Rafael Corchuelo.
#
# In keeping with the traditional purpose of furthering education and research, it is
# the policy of the copyright owner to permit non-commercial use and redistribution of
# this software. It has been tested carefully, but it is not guaranteed for any particular
# purposes.  The copyright owner does not offer any warranties or representations, nor do
# they accept any liabilities with respect to them.

This is a starter project.  It is intended to be a core learning asset for the students
who have enrolled the Design and Testing subject of the Software Engineering curriculum of the 
University of Sevilla.  This project helps them start working on their new information system 
projects.

To get this project up and running, please follow the appropriate guideline, taking into 
account that you must link Acme-Framework-22.1 excluding the following resources:

- **/fragments/**
 
 ELECCIONES REALIZADAS Y SU RAZÓN

Patronage: 
- A pesar de que el atributo startPeriod y endPeriod puedan parecer que estén en el futuro, lo que nos indica es que deben estar un mes más tarde (al menos
startPeriod) del momento de creación del Patronage, y no en el futuro de cuando se popula a la base de datos (cosa que ésta no tendría en cuenta a la hora de popular
con la etiqueta @Future). No obstante, si sólo fuese se nos dijese que debe de estar en el futuro del momento que se crea, la hubiéremos puesto, ya que nos hubiere
ahorrado añadir un método en el servicio de crear la entidad (que se harán en el futuro), mas no es el caso, debido a que debe de estar, al menos, un mes posterior al
momento de la creación. Dado que vamos a tener que añadir una validación sí o sí al método, y que la etiqueta @Future nos medio obligaría a poner los datos de
startPeriod y endPeriod muy en el futuro (para no estar cambiándolos constantemente), se ha decidido no colocar la etiqueta @Future en ninguno de los dos, y ya, a nivel
de servicio, crear la validación correspondiente.

Configuration: 
- En esta entidad, no se nos ha dado una definición exacta de cómo es, sino que se nos han aportado los datos que ésta llevara en primera (y única, se puede entender)
instancia, por lo que si son necesarios ciertos campos o no, es algo de nuestra elección, basándonos en el sentido común. 
    - Se ha decidido que no será totalmente necesario que haya palabras spam de ningún tipo (para que el administrador del sistema decida si quiere o no que haya
    palabras spam); pero el umbral de estas sí que será necesario, aunque no haya palabras spam (en caso de que se coloque un umbral sin haber palabras spam, éste no
    tendrá efecto alguno) para que, si se meten palabras spam, siempre haya un umbral. En caso de que no se coloque umbral, se podría poner a "0.00".
    - Para las divisas, será necesario poner siempre una divisa por defecto (que, aunque no se nos haya indicado por ahora, tendrá un uso en el futuro) y unas divisas
    aceptadas (ya que se podría entender que, al no haber ninguna divisa aceptada, no se podría introducir ningún tipo de moneda en el sistema).
- Los datos han decidido meterse separados por dobles puntos (palabras spam y divisas), dado que es un carácter que, muy difícilmente, pueda encontrarse en palabras
como tal, al contrario que los guiones.

Dasboards: 
- Para esta entidad se pedian agrupar algunos atributos por divisa, se ha decidido dejar esta funcionalidad para cuando para posteriormente en concreto cuando se 
realicen los dashboards services. Por tanto no se han escrito distintos atributos para cada tipo de moneda. Además, hemos pensado escribir un atributo por entidad,
no es necesario y aumentaria innecesariamente el tamaño del uml, pues estariamos hablando de casi triplicar el numero de atributos.
