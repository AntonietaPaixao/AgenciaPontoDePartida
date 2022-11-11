using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;


namespace PontoDePartidaAPIDotNet.Models
{
	[Table("Partida")]
	public class Partida
	{
		[Key]
		public int PartidaId { get; set; }

		[Required(ErrorMessage = "Informe o nome do campeonato.")]
		[StringLength(20)]
		public string Campeonato { get; set; }

		[Required(ErrorMessage = "Informe o nome do time da casa.")]
		[StringLength(20)]
		public string TimeCasa { get; set; }

		[Required(ErrorMessage = "Informe o nome do time da visitante.")]
		[StringLength(20)]
		public string TimeVisitante { get; set; }

		[Required(ErrorMessage = "Informe o nome da cidade onde ocorrerá a partida.")]
		[StringLength(20)]
		public string Cidade { get; set; }

		[Required(ErrorMessage = "Informe o nome do estádio onde ocorrerá a partida.")]
		[StringLength(20)]
		public string Estadio { get; set; }

		[Display(Name = "Data")]
		[Required]
		[DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}", ApplyFormatInEditMode = true)]
		[DataType(DataType.DateTime, ErrorMessage = "Data em formato inválido")]
		public DateTime Data { get; set; }

		[Display(Name = "Horario")]
		[Required]
		[DisplayFormat(DataFormatString = "{0:HH:mm}", ApplyFormatInEditMode = true)]
		[DataType(DataType.DateTime, ErrorMessage = "Data em formato inválido")]
		public DateTime Horario { get; set; }
	}
}


