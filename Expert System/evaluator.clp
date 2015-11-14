(deftemplate situacion_sartorial_corbata
	(slot tipo_camisa)
	(slot material)
	(slot longitud)
	(slot cuello_camisa)
	(slot cuello_usuario)
	(slot grosor)
	(slot anchura))

(deffacts inicio
	(inicio ambiente_vacio))

(defrule tipo_camisa
	(inicio ambiente_vacio)
	=>
	(printout t "Que tipo de camisa usas?" crlf
		"a) Formal, sin cuello" crlf
		"b) Formal, manga larga" crlf
		"c) Formal, manga corta" crlf
		"d) T-shirt/polo/henley" crlf
		"e) Formal, cuello dove tail" crlf
		"(a/b/c/d): ")
	(assert (situacion_sartorial_corbata (tipo_camisa (read)))))

(defrule lo_incomprensible
	(situacion_sartorial_corbata (tipo_camisa d))
	=>
	(printout t crlf crlf
		"Y quieres usar corbata?" crlf
		"(si/no): ")
	(assert (caso_raro (read))))

(defrule circus_circus
	(caso_raro si)
	=>
	(printout t "Bien, en ese caso la verdad cualquier nudo te conviene." crlf
		"Mientras mas estrafalario mejor." crlf
		"Solo te recomiendo que te tomes una buena foto para la inscripción" crlf
		"en la World Clown Association, no vaya a ser que te copien el personaje." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule informal
	(caso_raro no)
	=>
	(printout t "Bien pensado. Gracias por la conversación." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule formal_equivocado
	(situacion_sartorial_corbata (tipo_camisa a))
	=>
	(printout t "El asunto esta así: a menos que seas un actor" crlf
		"representando un pasajero del Titanic," crlf
		"te diría que más bien lo que te conviene es un corbatín" crlf
		"(de seda, negro o blanco) o un Ascot," crlf
		"si es que la ocasión realmente lo amerita; sino" crlf
		"simplemente te equivocaste de camisa." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule formal_manga_corta
	(situacion_sartorial_corbata (tipo_camisa c))
	=>
	(printout t "Eres acaso cajero en un banco estatal," crlf
		"o contador, o gerente de turno en un restaurante de comida rápida, o" crlf
		"ingeniero de la NASA?" crlf
		"(si/no): ")
	(assert (formal_forzado (read))))

(defrule formal_fingido
	(formal_forzado si)
	=>
	(printout t "En ese caso, el nudo Four in hand es el correcto." crlf
		"Es poco sofisticado, discreto y sin pretensiones, como la camisa." crlf
		"Obviamente, la corbata debe ser de poliester." crlf
		"Period" crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule intentar_de_nuevo
	(formal_forzado no)
	=>
	(printout t "En tal caso, mi consejo es que consigas una camisa de manga larga," crlf
		"y continuemos luego con esta conversación." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule sin_cuello
	(situacion_sartorial_corbata (tipo_camisa a))
	=>
	(printout t "Ese tipo de camisa se usa sin corbata. Fin de la historia." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule dove_tail
	(situacion_sartorial_corbata (tipo_camisa d))
	=>
	(printout t "A menos que seas un actor representando un pasajero del Titanic" crlf
		"no es recomendable corbata con esa camisa." crlf
		"Si la ocasión lo amerita, deberas usar un corbatín (de seda blanca o negra)" crlf
		"o un Ascot." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule definiendo_material
	(situacion_sartorial_corbata (tipo_camisa b))
	=>
	(printout t "Cual es el material de la corbata?" crlf
		"a) Seda/poliester/microfibra" crlf
		"b) Lana/punto" crlf
		"(a/b)? ")
	(assert (situacion_sartorial_corbata (material (read)))))

(defrule material_informal
	(situacion_sartorial_corbata (material b))
	=>
	(printout t "Vas a usar chaqueta de tweed o un Barbour ?" crlf
		"(si/no): ")
	(assert (chaqueta_informal (read))))

(defrule chaqueta_informal_correcta
	(chaqueta_informal si)
	=>
	(printout t "En ese caso, tanto el nudo four in hand como el Kent estarán bien." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule chaqueta_informal_incorrecta
	(chaqueta informal no)
	=>
	(printout t "Oops. Ejem...en ese caso quizá deberías considerar cambiar de corbata." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule material_serio
	(situacion_sartorial_corbata (material a))
	=>
	(printout t "En cuanto a la longitud de la corbata, es:" crlf
		"a) Apropiada"     crlf
		"b) Un poco larga" crlf
		"(a/b): ")
	(assert (situacion_sartorial_corbata (longitud (read)))))

(defrule longitud_excesiva
	(situacion_sartorial_corbata (longitud b))
	=>
	(printout t "Que tipo de cuello tiene la camisa?" crlf
		"a) Italiano" crlf
		"b) Inglés" crlf
		"(a/b): ")
	(assert (situacion_sartorial_corbata (cuello_camisa (read)))))

(defrule solucion_longitud_1
	(situacion_sartorial_corbata (longitud b))
	(situacion_sartorial_corbata (cuello_camisa a))
	=>
	(printout t "Recomiendo el nudo Windsor, con la sección angosta tan larga como sea posible." crlf)
	(assert (segundo_examen si)))

(defrule solucion_longitud_2
	(situacion_sartorial_corbata (longitud b))
	(situacion_sartorial_corbata (cuello_camisa b))
	=>
	(printout t "Recomiendo el nudo Prince Albert, con la sección angosta tan larga como sea posible." crlf)
	(assert (segundo_examen si)))

(defrule reexaminar
	(segundo_examen si)
	=>
	(printout t "Es aún muy larga?" crlf
		"(si/no): ")
	(assert (aun_muy_larga (read))))

(defrule reexamen_bien
	(aun_muy_larga no)
	=>
	(printout t "Vale. Asunto solucionado." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))

(defrule reexamen_mal
	(aun_muy_larga si)
	=>
	(printout t "Bueno, se hizo todo lo posible." crlf
		"No queda mas alternativa que cambiar de corbata (y desechar esa inmediatamente)." crlf)
	(printout t crlf "(Digita un caracter cualquiera (y RETURN) para terminar)")
	(read)
	(exit))
