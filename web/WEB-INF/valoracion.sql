USE [ClienteValoracion]
GO
/****** Object:  Table [dbo].[Valoracion]    Script Date: 03/11/2018 06:28:18 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Valoracion](
	[idValoracion] [int] IDENTITY(1,1) NOT NULL,
	[tipoValoracion] [varchar](250) NULL,
	[fecha] [datetime] NULL,
 CONSTRAINT [PK_Valoracion] PRIMARY KEY CLUSTERED 
(
	[idValoracion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
