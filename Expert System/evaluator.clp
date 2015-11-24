(deftemplate corbata
	(slot material)
	(slot chaqueta_tweed)
	(slot cuello_camisa)
	(slot cuello_usuario)
	(slot ancho_corbata)
	(slot grosor_corbata)
	(slot largo_corbata)
	(slot camisa))

(deffacts inicio
	(inicio ambiente_vacio))

(defrule material
	(inicio ambiente_vacio)
	=>
	(printout t "De qué material está hecha la corbata?" crlf
		"a) Lana/Punto" crlf
		"b) Seda" crlf
		"c) Sintético" crlf
		"d) De otro" crlf
		"(a/b/c/d): ")
	(assert (corbata (material (read)))))

(defrule lana
	(corbata (material a))
	=>
	(printout t "Vas a usar una chaqueta de tweed?" crlf
		"(s/n): ")
	(assert (corbata (chaqueta_tweed (read)))))

(defrule tweed_si
	(corbata (chaqueta_tweed s))
	=>
	(printout t "Four in Hand o Kent estaría bien" crlf))

(defrule tweed_no
	(corbata (chaqueta_tweed n))
	=>
	(printout t "Oops. Deberias considerar cambiar de corbata" crlf))

(defrule seda
	(corbata (material b))
	=>
	(printout t "Utiliza el nudo Eldredge" crlf))

(defrule sintetico
	(corbata (material c))
	=>
	(printout t "Qué tipo de cuello tiene la camisa?" crlf
		"a) Inglés" crlf
		"b) Italiano" crlf
		"(a/b)")
	(assert (corbata (cuello_camisa (read)))))

(defrule cuello_ingles
	(corbata (cuello_camisa a))
	=>
	(printout t "Qué tan ancho es su cuello?" crlf
		"a) Grueso" crlf
		"b) Delgado" crlf
		"c) No importa" crlf
		"(a/b/c)")
	(assert (corbata (cuello_usuario (read)))))

(defrule cuello_grueso
	(corbata (cuello_usuario a))
	=>
	(printout t "Utiliza un nudo Half Windsor" crlf))

(defrule cuello_delgado
	(corbata (cuello_usuario b))
	=>
	(printout t "Qué tan ancha es su corbata?" crlf
		"a) Delgada" crlf
		"b) Ancha" crlf
		"c) No importa" crlf
		"(a/b/c)")
	(assert (corbata (ancho_corbata (read)))))

(defrule corbata_delgada
	(corbata (ancho_corbata a))
	=>
	(printout t "Utiliza un nudo Four in Hand" crlf))

(defrule corbata_ancha
	(corbata (ancho_corbata b))
	=>
	(printout t "Utiliza un nudo Kent" crlf))

(defrule corbata_indiferente
	(corbata (ancho_corbata c))
	=>
	(printout t "Qué tan gruesa es su corbata?" crlf
		"a) Delgada" crlf
		"b) No importa" crlf
		"(a/b)")
	(assert (corbata (grosor_corbata (read)))))

(defrule grosor_corbata_delgada
	(corbata (grosor_corbata a))
	=>
	(printout t "Merovingian" crlf))

(defrule grosor_corbata_indiferente
	(corbata (grosor_corbata b))
	=>
	(printout t "Utiliza un nudo Prince Albert" crlf))

(defrule cuello_italiano
	(corbata (cuello_camisa b))
	=>
	(printout t "Qué tan larga es la corbata?" crlf
		"a) Corta" crlf
		"b) Larga" crlf
		"(a/b)")
	(assert (corbata (largo_corbata (read)))))

(defrule corbata_corta
	(corbata (largo_corbata a))
	=>
	(printout t "Viste usted una camisa formal?" crlf
		"(s/n)")
	(assert (corbata (camisa (read)))))

(defrule camisa_formal
	(corbata (camisa s))
	=>
	(printout t "Si es usted un cajero de banco estatal, contador, gerente de turno en restaurante de comida rápida o ingeniero de la NASA utiliza un nudo Four in Hand" crlf))

(defrule camisa_informal
	(corbata (camisa n))
	=>
	(printout t "Utiliza un nudo Prince Albert" crlf))

(defrule corbata_larga
	(corbata (largo_corbata b))
	=>
	(printout t "Utiliza un nudo Windsor" crlf))

(defrule de_otro
	(corbata (material d))
	=>
	(printout t "Utiliza un nudo Four in Hand" crlf))
