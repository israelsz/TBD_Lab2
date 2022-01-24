<template>
  <div>
    <b-navbar toggleable="lg" type="light" variant="white">

      <b-navbar-brand href="#" class="imagen-texto">
        <img
          src="./assets/cheems.png"
          width="80"
          height="80"
          class="d-inline-block align-top"
          alt="Logo app"
        />
        Voluntariado App
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item class="enlace"> <NuxtLink to="/">Inicio</NuxtLink> </b-nav-item>
          <b-nav-item class="enlace"> <NuxtLink to="/ranking">Ranking</NuxtLink> </b-nav-item>
          <b-nav-item class="enlace"> <NuxtLink to="/participantes">Participantes</NuxtLink> </b-nav-item>
          <b-nav-item class="enlace"> <NuxtLink to="/mapa-tareas">Mapa de tareas</NuxtLink> </b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {};
</script>

<style>
@import "./style.css";
</style>
