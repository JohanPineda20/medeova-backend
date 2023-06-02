-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 30-05-2023 a las 22:50:06
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `medeova_teoria-computacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

DROP TABLE IF EXISTS `actividad`;
CREATE TABLE IF NOT EXISTS `actividad` (
  `id_actividad` int NOT NULL AUTO_INCREMENT,
  `id_tipo` int NOT NULL,
  `id_tema` int NOT NULL,
  `titulo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `objetivo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `instrucciones` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `enlace` text NOT NULL,
  PRIMARY KEY (`id_actividad`),
  KEY `id_tipo` (`id_tipo`),
  KEY `id_tema` (`id_tema`)
) ENGINE=MyISAM AUTO_INCREMENT=10000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`id_actividad`, `id_tipo`, `id_tema`, `titulo`, `objetivo`, `instrucciones`, `enlace`) VALUES
(9999, 2, 2, 'Sopa de letras', 'Esta es una actividad de prueba', 'Así es como se hace una actividad de prueba', 'https://es.educaplay.com/recursos-educativos/15108838-juego_de_palabras.html'),
(10000000, 2, 2, 'Sopa de letras', 'Esta es una actividad de prueba', 'Así es como se hace una actividad de prueba', 'https://es.educaplay.com/recursos-educativos/15108838-juego_de_palabras.html');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

DROP TABLE IF EXISTS `comentario`;
CREATE TABLE IF NOT EXISTS `comentario` (
  `id_comentario` int NOT NULL AUTO_INCREMENT,
  `id_usuario` varchar(15) NOT NULL,
  `id_tema` int NOT NULL,
  `comentario` text NOT NULL,
  `created_at` date DEFAULT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `id_estudiante` (`id_usuario`),
  KEY `id_tema` (`id_tema`)
) ENGINE=MyISAM AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`id_comentario`, `id_usuario`, `id_tema`, `comentario`, `created_at`) VALUES
(999, '1151910', 2, 'Este tema es muy interesante', '2023-05-30'),
(1001, '1151910', 2, 'Otro comentario', '2023-05-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_actividad`
--

DROP TABLE IF EXISTS `detalle_actividad`;
CREATE TABLE IF NOT EXISTS `detalle_actividad` (
  `id_actividad` int NOT NULL,
  `id_usuario` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dificultad` tinyint NOT NULL,
  `comentario` text NOT NULL,
  PRIMARY KEY (`id_actividad`,`id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_rol`
--

DROP TABLE IF EXISTS `detalle_rol`;
CREATE TABLE IF NOT EXISTS `detalle_rol` (
  `id_detalle` int NOT NULL AUTO_INCREMENT,
  `id_usuario` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `id_user` (`id_usuario`),
  KEY `id_rol` (`id_rol`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `detalle_rol`
--

INSERT INTO `detalle_rol` (`id_detalle`, `id_usuario`, `id_rol`) VALUES
(1, '1151910', 2),
(2, '1155800', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multimedia`
--

DROP TABLE IF EXISTS `multimedia`;
CREATE TABLE IF NOT EXISTS `multimedia` (
  `id_multimedia` int NOT NULL AUTO_INCREMENT,
  `id_tipo` int NOT NULL,
  `id_subtema` int NOT NULL,
  `titulo` text NOT NULL,
  `enlace` text NOT NULL,
  `observacion` text NOT NULL,
  PRIMARY KEY (`id_multimedia`),
  KEY `id_subtema` (`id_subtema`),
  KEY `id_tipo` (`id_tipo`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `multimedia`
--

INSERT INTO `multimedia` (`id_multimedia`, `id_tipo`, `id_subtema`, `titulo`, `enlace`, `observacion`) VALUES
(1, 1, 1, 'Primeros pasos de la teoría de la computación', 'https://www.youtube.com/embed/29Qp_AWXFt4', ''),
(2, 2, 1, 'Introducción a la teoría de la computación', 'https://books.google.com.co/books?id=NXQE8NJw9d4C&lpg=PA1&dq=Introducci%C3%B3n%2Ba%2Bla%2BTeor%C3%ADa%2Bde%2Bla%2Bcomputaci%C3%B3n&lr&hl=es&pg=PR1&output=embed', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `nombre`) VALUES
(1, 'Docente'),
(2, 'Estudiante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subtema`
--

DROP TABLE IF EXISTS `subtema`;
CREATE TABLE IF NOT EXISTS `subtema` (
  `id_subtema` int NOT NULL AUTO_INCREMENT,
  `id_tema` int NOT NULL,
  `titulo` text NOT NULL,
  `imagen` text NOT NULL,
  `descripcion` text NOT NULL,
  `contenido` text NOT NULL,
  PRIMARY KEY (`id_subtema`),
  KEY `id_tema` (`id_tema`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `subtema`
--

INSERT INTO `subtema` (`id_subtema`, `id_tema`, `titulo`, `imagen`, `descripcion`, `contenido`) VALUES
(1, 2, 'Lógica matemática', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(2, 2, 'Arquitectura computacional', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(3, 2, 'Algoritmos y análisis de algoritmos', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(4, 2, 'Gramáticas y lenguajes', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(5, 3, 'Límites de la computación', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(6, 3, 'Problemas indecidibles', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(7, 3, 'Problemas computables y complejidad computacional', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(8, 4, 'Autómatas', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(9, 4, 'Funciones recursivas', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.'),
(10, 4, 'Cálculo lambda', 'https://lavidauniversitaria2016.files.wordpress.com/2017/04/conocimiento.jpg?w=1000', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer varius sem venenatis neque tempus bibendum. Suspendisse potenti. In hac habitasse platea dictumst. Phasellus tempor venenatis efficitur. Nulla facilisi. Vivamus a elementum dolor. Mauris a aliquet massa, ac tempus neque. Mauris feugiat tincidunt auctor. Vivamus ut rhoncus lorem, ut mattis magna. Morbi fringilla sapien quis diam lacinia, eget vulputate diam accumsan. Nullam pretium in dui id mattis. Aenean vitae arcu nec velit faucibus dictum ac id orci. Sed pellentesque eleifend dui, eget iaculis diam facilisis non. Curabitur quis facilisis est, a imperdiet nisl. Vestibulum interdum lorem non enim elementum, ac sodales libero consequat. Nullam ac ligula nec velit tristique venenatis ac sit amet odio. Donec bibendum aliquam felis, at sagittis dui suscipit non.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema`
--

DROP TABLE IF EXISTS `tema`;
CREATE TABLE IF NOT EXISTS `tema` (
  `id_tema` int NOT NULL AUTO_INCREMENT,
  `id_unidad` int NOT NULL,
  `titulo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `imagen` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`id_tema`),
  KEY `id_unidad` (`id_unidad`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tema`
--

INSERT INTO `tema` (`id_tema`, `id_unidad`, `titulo`, `imagen`, `descripcion`) VALUES
(1, 1, 'Historia de la teoría de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(2, 1, 'Conceptos básicos de la teoría de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación se ocupa de determinar qué problemas pueden ser resueltos computacionalmente y con qué eficiencia. La teoría considera distintos modelos de cómputo, como los autómatas finitos (que son los más sencillos), las máquinas de Turing (que son las computadoras usuales de hoy en día) y las computadoras cuánticas (cuyo funcionamiento no es digital). Las lógicas y los lenguajes formales juegan un rol central en la teoría de la computación porque permiten expresar propiedades de los programas y razonar sobre su comportamiento. La teoría de la computación también se encarga de entender el límite entre los problemas computables y los no-computables y, dentro del mundo de lo computable, clasificarlos de acuerdo a su grado de simpleza o dificultad. En particular, estudiamos lógicas con buen comportamiento computacional, como las lógicas modales, tanto desde el punto de vista de la teoría de modelos como desde el de la teoría de prueba. Analizamos lenguajes eficientes de consultas que permiten razonar sobre distintas estructuras de representación del conocimiento. A un nivel más abstracto, investigamos las propiedades teóricas de los sistemas de reescritura y los modelos de cómputo fuertes, como el cálculo lambda.'),
(3, 1, 'Problemas y límites de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(4, 1, 'Modelos de cómputo', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(5, 2, 'Historia de la teoría de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(6, 2, 'Conceptos básicos de la teoría de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación se ocupa de determinar qué problemas pueden ser resueltos computacionalmente y con qué eficiencia. La teoría considera distintos modelos de cómputo, como los autómatas finitos (que son los más sencillos), las máquinas de Turing (que son las computadoras usuales de hoy en día) y las computadoras cuánticas (cuyo funcionamiento no es digital). Las lógicas y los lenguajes formales juegan un rol central en la teoría de la computación porque permiten expresar propiedades de los programas y razonar sobre su comportamiento. La teoría de la computación también se encarga de entender el límite entre los problemas computables y los no-computables y, dentro del mundo de lo computable, clasificarlos de acuerdo a su grado de simpleza o dificultad. En particular, estudiamos lógicas con buen comportamiento computacional, como las lógicas modales, tanto desde el punto de vista de la teoría de modelos como desde el de la teoría de prueba. Analizamos lenguajes eficientes de consultas que permiten razonar sobre distintas estructuras de representación del conocimiento. A un nivel más abstracto, investigamos las propiedades teóricas de los sistemas de reescritura y los modelos de cómputo fuertes, como el cálculo lambda.'),
(7, 2, 'Problemas y límites de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(8, 2, 'Modelos de cómputo', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(9, 3, 'Historia de la teoría de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(10, 3, 'Conceptos básicos de la teoría de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación se ocupa de determinar qué problemas pueden ser resueltos computacionalmente y con qué eficiencia. La teoría considera distintos modelos de cómputo, como los autómatas finitos (que son los más sencillos), las máquinas de Turing (que son las computadoras usuales de hoy en día) y las computadoras cuánticas (cuyo funcionamiento no es digital). Las lógicas y los lenguajes formales juegan un rol central en la teoría de la computación porque permiten expresar propiedades de los programas y razonar sobre su comportamiento. La teoría de la computación también se encarga de entender el límite entre los problemas computables y los no-computables y, dentro del mundo de lo computable, clasificarlos de acuerdo a su grado de simpleza o dificultad. En particular, estudiamos lógicas con buen comportamiento computacional, como las lógicas modales, tanto desde el punto de vista de la teoría de modelos como desde el de la teoría de prueba. Analizamos lenguajes eficientes de consultas que permiten razonar sobre distintas estructuras de representación del conocimiento. A un nivel más abstracto, investigamos las propiedades teóricas de los sistemas de reescritura y los modelos de cómputo fuertes, como el cálculo lambda.'),
(11, 3, 'Problemas y límites de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(12, 3, 'Modelos de cómputo', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(13, 4, 'Historia de la teoría de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(14, 4, 'Conceptos básicos de la teoría de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación se ocupa de determinar qué problemas pueden ser resueltos computacionalmente y con qué eficiencia. La teoría considera distintos modelos de cómputo, como los autómatas finitos (que son los más sencillos), las máquinas de Turing (que son las computadoras usuales de hoy en día) y las computadoras cuánticas (cuyo funcionamiento no es digital). Las lógicas y los lenguajes formales juegan un rol central en la teoría de la computación porque permiten expresar propiedades de los programas y razonar sobre su comportamiento. La teoría de la computación también se encarga de entender el límite entre los problemas computables y los no-computables y, dentro del mundo de lo computable, clasificarlos de acuerdo a su grado de simpleza o dificultad. En particular, estudiamos lógicas con buen comportamiento computacional, como las lógicas modales, tanto desde el punto de vista de la teoría de modelos como desde el de la teoría de prueba. Analizamos lenguajes eficientes de consultas que permiten razonar sobre distintas estructuras de representación del conocimiento. A un nivel más abstracto, investigamos las propiedades teóricas de los sistemas de reescritura y los modelos de cómputo fuertes, como el cálculo lambda.'),
(15, 4, 'Problemas y límites de la computación', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.'),
(16, 4, 'Modelos de cómputo', 'https://compilandoconocimiento.files.wordpress.com/2017/01/mat32.gif?w=320&h=220', 'La teoría de la computación comienza propiamente a principios del siglo XX, poco antes que las computadoras electrónicas fuesen inventadas. En esta época varios matemáticos se preguntaban si existía un método universal para resolver todos los problemas matemáticos. Para ello debían desarrollar la noción precisa de método para resolver problemas, es decir, la definición formal de algoritmo. Algunos de estos modelos formales fueron propuestos por precursores como Alonzo Church (cálculo Lambda), Kurt Gödel (funciones recursivas) y Alan Turing (máquina de Turing). Se ha mostrado que estos modelos son equivalentes en el sentido de que pueden simular los mismos algoritmos, aunque lo hagan de maneras diferentes. Entre los modelos de cómputo más recientes se encuentran los lenguajes de programación, que también han mostrado ser equivalentes a los modelos anteriores; esto es una fuerte evidencia de la conjetura de Church-Turing, de que todo algoritmo habido y por haber se puede simular en una máquina de Turing, o equivalentemente, usando funciones recursivas. En 2007 Nachum Dershowitz y Yuri Gurevich publicaron una demostración de esta conjetura basándose en cierta axiomatización de algoritmos.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_actividad`
--

DROP TABLE IF EXISTS `tipo_actividad`;
CREATE TABLE IF NOT EXISTS `tipo_actividad` (
  `id_tipo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tipo_actividad`
--

INSERT INTO `tipo_actividad` (`id_tipo`, `nombre`) VALUES
(1, 'Quiz'),
(2, 'Sopa de Letras');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad`
--

DROP TABLE IF EXISTS `unidad`;
CREATE TABLE IF NOT EXISTS `unidad` (
  `id_unidad` int NOT NULL AUTO_INCREMENT,
  `titulo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `imagen` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`id_unidad`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `unidad`
--

INSERT INTO `unidad` (`id_unidad`, `titulo`, `imagen`, `descripcion`) VALUES
(1, 'Introducción a la Teoría de la Computación', 'assets/lenguaje2 1.png', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.'),
(2, 'Derivación de gramáticas lineales y árboles de derivación', 'assets/lenguaje2 1.png', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.'),
(3, 'Conversión de autómatas AFND a AFD', 'assets/lenguaje2 1.png', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.'),
(4, 'Autómatas a pila', 'assets/lenguaje2 1.png', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit, vero facere? Odit libero nam suscipit dolorem repellendus, exercitationem itaque laboriosam culpa rerum rem hic voluptas at ducimus, vel nemo iste.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo` varchar(15) NOT NULL,
  `per_nom` varchar(80) NOT NULL,
  `sdo_nom` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `per_apell` varchar(80) NOT NULL,
  `sdo_apell` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `clave` varchar(100) NOT NULL,
  `created` datetime DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codigo`, `per_nom`, `sdo_nom`, `per_apell`, `sdo_apell`, `email`, `clave`) VALUES
('1151910', 'PAULA', 'VALENTINA', 'RICO', 'LINDARTE', 'paulavalentinarlin@ufps.edu.co', '12345'),
('1155800', 'Juan', 'Carlos', 'Zapata', 'Garcia', 'docente@ufps.edu.co', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `verification_token`
--

--
-- Estructura de tabla para la tabla `verification_token`
--
DROP TABLE IF EXISTS `verification_token`;
CREATE TABLE `verification_token` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `fecha_expiracion` datetime DEFAULT NULL,
    `token` varchar(255) DEFAULT NULL,
    `usuario_id` varchar(15) DEFAULT NULL,
     PRIMARY KEY (`id`),
     KEY `usuario_id` (`usuario_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- -----------------------------------------------------------


--
-- Estructura de tabla para la tabla `voto`
--

DROP TABLE IF EXISTS `voto`;
CREATE TABLE IF NOT EXISTS `voto` (
  `id_multimedia` int NOT NULL,
  `id_usuario` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `valoracion` int NOT NULL,
  PRIMARY KEY (`id_multimedia`,`id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
