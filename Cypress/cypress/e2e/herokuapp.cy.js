describe('Pruebas de Regresión de https://the-internet.herokuapp.com/', () => {
  it('Validar la página de Inputs', () => {
    // Visitar herokuapp
    cy.visit('https://the-internet.herokuapp.com/');

    // Buscamos en Welcome to the-internet la opción inputs
    cy.get('a[href="/inputs"]').click();

    // Validar la palabra "Inputs"
    cy.contains('h3', 'Inputs').should('be.visible');

    // Introduce el texto en el campo
    cy.get('input[type="number"]').type('12345');

    // Validar la palabra "number"
    cy.get('input[type="number"]').should('have.attr', 'type', 'number');

    // Mensaje de éxito
    cy.log('Se completó el campo correctamente');

    // Regresar a la página inicial
    cy.visit('https://the-internet.herokuapp.com/');
  });

  it('Validar la página de Checkboxes', () => {
    // Visitar herokuapp
    cy.visit('https://the-internet.herokuapp.com/');

    // Buscamos en Welcome to the-internet la opción Checkboxes
    cy.get('a[href="/checkboxes"]').click();

    // Validar la palabra "Checkboxes"
    cy.contains('h3', 'Checkboxes').should('be.visible');

    // Seleccionar el primer checkbox
    cy.get('input[type="checkbox"]').first().check();
  });

  it('Error al introducir texto en el campo de número', () => {
    // Visitar herokuapp
    cy.visit('https://the-internet.herokuapp.com/');

    // Buscamos en Welcome to the-internet la opción inputs
    cy.get('a[href="/inputs"]').click();

    // Validar la palabra "Inputs"
    cy.contains('h3', 'Inputs').should('be.visible');

    // Introduce texto en el campo de número
    cy.get('input[type="number"]').type('texto');

    // Validar el mensaje de error
    cy.get('input[type="number"]:invalid').should('exist');
  });

  it('Error al seleccionar un checkbox inexistente', () => {
    // Visitar herokuapp
    cy.visit('https://the-internet.herokuapp.com/');

    // Buscamos en Welcome to the-internet la opción Checkboxes
    cy.get('a[href="/checkboxes"]').click();

    // Validar la palabra "Checkboxes"
    cy.contains('h3', 'Checkboxes').should('be.visible');

    // Intentar seleccionar un checkbox inexistente
    cy.get('input[type="checkbox"]').eq(10).check({ force: true }).should('not.exist');
  });
});
