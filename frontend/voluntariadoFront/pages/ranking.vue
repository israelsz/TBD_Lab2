<template>
  <div>
    <NavBar />
    <b-container class="index-container mt-5">
      <h2>Ranking de participantes por tarea</h2>
      <p>En esta sección usted podrá conocer que voluntarios son los más adecuados para cada tarea</p>
      <div class="dropdown mt-4">
        <span class="mr-3">Tarea:</span>
        <select v-model="tareaSeleccionada" @change="onChangeTarea">
          <option value="">Selecione una tarea</option>
          <option v-for="(tarea, id) in tareas" :value="tarea" :key="id">
            {{ tarea.nombre }}
          </option>
        </select>
      </div>

      <div>
        <h2 v-if="mostrar">Voluntarios:</h2>
        <div v-for="voluntario in voluntarios" :key="voluntario.id" class="mt-3">
          <b-card>
            <b-card-text>
              <h1>{{ voluntario.nombre }} {{ voluntario.apellido }}</h1>
              <h4 class="mt-1">Id de voluntario: {{ voluntario.id }}</h4>
              <h4 class="mt-1">Estado de salud: {{voluntario.estado_salud}}</h4>
              <p class="mt-1">Este voluntario posee una cantidad de <b>{{voluntario.puntos}} </b> puntos para esta tarea</p>
            </b-card-text>
          </b-card>
        </div>
      </div>
    </b-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tareas: [],
      tareaSeleccionada: "",
      voluntarios: [],
      mostrar: false
    };
  },
  methods: {
    async conseguirTareas() {
      const respuesta = await this.$axios.$get("/tareas");
      this.tareas = respuesta;
    },
    async onChangeTarea() {
      const respuesta2 = await this.$axios.$get(`/voluntariesRankedPerTask/${this.tareaSeleccionada.id}`);
      this.voluntarios = respuesta2;
      this.mostrar = true;
    },
  },
  //Función que se ejecuta al cargar el componente
  created: function () {
    this.conseguirTareas();
  },
};
</script>

<style></style>
