<template>
  <div>
    <NavBar />
    <h2>Voluntarios que más han participado en tareas de una emergencia</h2>
    <p>En esta sección usted podrá conocer que voluntarios han realizado terminado más tareas de cada emergencia</p>
    <b-card-group deck>
      <b-card header="Emergencias" >
        <b-list-group v-for="emergencia in emergencias" :key="emergencia.id" >
          <b-list-group-item button @click='onChangeEmergencia(emergencia.id)'>
            <h5>{{emergencia.nombre}}</h5>
            <p class="mb-1"> {{emergencia.descripcion}}. </p>
            <small> Ubicación: {{emergencia.ubicacion}} </small>
          </b-list-group-item>
        </b-list-group>
      </b-card>

      <b-card header="Voluntarios que han participado">
        <b-list-group v-for="voluntario in voluntarios" :key="voluntario.id" >
          <b-list-group-item >
            <h5>{{voluntario.nombre}} {{voluntario.apellido}}</h5>
            <p class="mb-1"> El voluntario ha participado en {{voluntario.cantidad_tareas}} tareas de la emergencia seleccionada.</p>
          </b-list-group-item>
        </b-list-group>
      </b-card>
    </b-card-group>
  </div>
</template>

<script>
export default {
  data() {
    return {
      emergencias: [],
      voluntarios: [],
    };
  },
  methods: {
    async conseguirEmergencias() {
      const respuesta = await this.$axios.$get("/emergencies");
      this.emergencias = respuesta;
    },
    async onChangeEmergencia(id) {
      const respuesta2 = await this.$axios.$get(`/voluntariesPerParticipation/${id}`);
      this.voluntarios = respuesta2;
      this.mostrar = true;
    },
  },
  //Función que se ejecuta al cargar el componente
  created: function () {
    this.conseguirEmergencias();
  },
};
</script>

<style></style>

