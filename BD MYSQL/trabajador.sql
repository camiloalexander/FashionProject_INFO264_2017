-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-10-2017 a las 22:19:30
-- Versión del servidor: 5.7.19
-- Versión de PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_peluqueria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `id_trabajador` int(5) NOT NULL,
  `run` varchar(15) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(150) CHARACTER SET utf8 NOT NULL,
  `telefono` varchar(30) CHARACTER SET utf8 NOT NULL,
  `pass` varchar(150) CHARACTER SET utf8 NOT NULL,
  `privilegios` int(5) NOT NULL,
  `estado` int(5) NOT NULL,
  `fecha_ingreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`id_trabajador`, `run`, `nombre`, `telefono`, `pass`, `privilegios`, `estado`, `fecha_ingreso`) VALUES
(1, '188863841', 'camilo alarcón', '123123', '123', 777, 1, '2017-10-06'),
(2, '76057063k', 'pancho', '123', '123456', 111, 1, '2017-10-06'),
(3, '107014667', 'javier', '879123', 'habdkasd', 111, 1, '2017-10-06'),
(4, '141475649', 'nombre', '+5698273832', '.-.-.', 111, 1, '2017-10-06');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`id_trabajador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `id_trabajador` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
