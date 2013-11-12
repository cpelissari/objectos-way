  public Insert getInsert() {
    return Insert.into("WAY.ENTIDADES")
        .value("ID", id)
        .value("QUANTIDADE", quantidade)
        .value("NOME", nome)
        .value("PREFIXO", prefixo)
  }