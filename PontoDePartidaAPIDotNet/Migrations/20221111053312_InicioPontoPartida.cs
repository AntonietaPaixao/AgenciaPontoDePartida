using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace PontoDePartidaAPIDotNet.Migrations
{
    /// <inheritdoc />
    public partial class InicioPontoPartida : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Partida",
                columns: table => new
                {
                    PartidaId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Campeonato = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    TimeCasa = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    TimeVisitante = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    Cidade = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    Estadio = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    Data = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Horario = table.Column<DateTime>(type: "datetime2", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Partida", x => x.PartidaId);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Partida");
        }
    }
}
