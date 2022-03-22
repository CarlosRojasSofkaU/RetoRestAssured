#language:es

Característica: Busqueda de un usuario específico
  Como un usuario de la plataforma
  nececito consultar usuarios especificos de la plataforma
  para poder consultar su informacion personal

  Escenario: usuario especifico no encontrado
    Dado el usuario esta en la pagina de busqueda de usuarios registrados
    Cuando el usuario hace una peticion de busqueda
    Entonces el usuario debera ver un codigo de respuesta exitoso y un token vacio