package source_code

class IllegalNoteTypeException(message: String) extends Exception(message)
class UnknownKeyException(message: String) extends Exception(message)
class CorruptedFileException(message: String) extends Exception(message)