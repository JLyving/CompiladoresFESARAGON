package fes.aragon;
import static fes.aragon.Tokens.*;

%%

%class Analizador
%type Tokens
%unicode

/* Comments */
startComment = \{
endComment = \}
contentComment= [^}]*
Comment = {startComment}{contentComment}{endComment}

UnicodeLetter  = [:letter:]
UnicodeDigit   = [:digit:]
Letter         = {UnicodeLetter}|"_"


/* White spaces*/
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]


%%




	/* Reserved Words */
	"program"                      	{ return PALABRARESERVADA; }
	"begin"						   	{ return PALABRARESERVADA; }
	"and"							{ return PALABRARESERVADA; }
	"array"							{ return PALABRARESERVADA; }
	"case"							{ return PALABRARESERVADA; }
	"const"						   	{ return PALABRARESERVADA; }
	"do"							{ return PALABRARESERVADA; }
	"if"							{ return PALABRARESERVADA; }
	"else"							{ return PALABRARESERVADA; }
	"for"							{ return PALABRARESERVADA; }
	"function"					   	{ return PALABRARESERVADA; }
	"not"							{ return PALABRARESERVADA; }
	"or"							{ return PALABRARESERVADA; }
	"procedure"						{ return PALABRARESERVADA; }
	"program"						{ return PALABRARESERVADA; }
	"repeat"						{ return PALABRARESERVADA; }
	"set"							{ return PALABRARESERVADA; }
	"then"							{ return PALABRARESERVADA; }
	"type"							{ return PALABRARESERVADA; }
	"var"                          	{ return PALABRARESERVADA; }
	"while"							{ return PALABRARESERVADA; }
	"string"						{ return PALABRARESERVADA; }
	"label"                         { return PALABRARESERVADA; }
	"of"                           	{ return PALABRARESERVADA; }
	"file"                         	{ return PALABRARESERVADA; }
	"goto"						   	{ return PALABRARESERVADA; }
	"until"						   	{ return PALABRARESERVADA; }
	"to"						   	{ return PALABRARESERVADA; }
	"with"					   	   	{ return PALABRARESERVADA; }
	"mod"						   	{ return PALABRARESERVADA; }
	"in"							{ return PALABRARESERVADA; }
	"end"                          	{ return PALABRARESERVADA; }



    /* White spaces */
    {WhiteSpace}				    { /*Ignore*/ }

    /*Comments*/
    {Comment}						{ return COMENTARIO; }

    /*Identificadores*/
    [A-Za-z_][A-Za-z_0-9]*			{ return IDENTIFICADOR; }